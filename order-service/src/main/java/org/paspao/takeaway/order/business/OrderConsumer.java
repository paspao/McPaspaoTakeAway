package org.paspao.takeaway.order.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.order.bean.OrderDTO;
import org.paspao.takeaway.order.dao.OrderRepository;
import org.paspao.takeaway.order.entity.Order;
import org.paspao.takeaway.order.port.IOrderMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 11/09/19.
 */
@Service
public class OrderConsumer implements IOrderMessaging {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void callback(String message)
    {
        try {
            OrderDTO orderDTO=mapper.readValue(message, OrderDTO.class);
            Optional<Order> orderOptional=orderRepository.findById(orderDTO.getId());
            if(orderOptional.isPresent())
            {
                Order order=orderOptional.get();
                order.setStatusDescription(orderDTO.getStatusDescription());
                order.setOrderStatus(orderDTO.getOrderStatus());
                orderRepository.save(order);
            }
        }  catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
