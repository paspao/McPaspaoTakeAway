package org.paspao.takeaway.order.business;

import org.dozer.DozerBeanMapper;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.order.dao.OrderRepository;
import org.paspao.takeaway.order.entity.Order;
import org.paspao.takeaway.order.port.OrderServicePublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderServicePublish orderServicePublish;


    @Autowired
    private DozerBeanMapper dozer;

    public void createOrder(OrderDTO orderDTO){
        Order order =new Order();
        dozer.map(orderDTO,order);
        order=orderRepository.save(order);
        orderServicePublish.sendOrder(order);
        logger.info("Order with id "+order.getId()+" sent to kitchen service");
    }
}
