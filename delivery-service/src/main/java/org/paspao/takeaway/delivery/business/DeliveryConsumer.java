package org.paspao.takeaway.delivery.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.delivery.dao.DeliveryRepository;
import org.paspao.takeaway.delivery.entity.Delivery;
import org.paspao.takeaway.delivery.port.IDeliveryMessging;
import org.paspao.takeaway.delivery.port.IDeliveryPublisher;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.dto.type.OrderStatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 12/09/19.
 */
@Service
public class DeliveryConsumer  implements IDeliveryMessging {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryConsumer.class);

    @Autowired
    private IDeliveryPublisher deliveryPublisher;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void consumeMessage(String content) {

        try {
            OrderDTO orderDTO = objectMapper.readValue(content, OrderDTO.class);
            Delivery delivery=new Delivery();
            delivery.setAddressDTO(orderDTO.getAddressDTO());
            delivery.setOrderId(orderDTO.getId());
            deliveryRepository.save(delivery);
            logger.info("Processing delivery id "+delivery.getId()+" for order id "+orderDTO.getId());
            Thread.sleep(5000);
            orderDTO.setOrderStatus(OrderStatusType.DELIVERED);
            orderDTO.setStatusDescription("Delivered");
            deliveryPublisher.sendToOrderCallback(orderDTO);
            logger.info("Delivered order id "+orderDTO.getId());

        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        }


    }
}
