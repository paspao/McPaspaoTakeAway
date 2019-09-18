package org.paspao.takeaway.order.business;

import org.dozer.DozerBeanMapper;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.order.dao.OrderRepository;
import org.paspao.takeaway.order.entity.Order;
import org.paspao.takeaway.order.port.IOrderServicePublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IOrderServicePublish orderServicePublish;


    @Autowired
    private DozerBeanMapper dozer;

    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order =new Order();
        dozer.map(orderDTO,order);
        order=orderRepository.save(order);
        orderServicePublish.sendOrder(order);
        logger.info("Order with id "+order.getId()+" sent to kitchen service");
        OrderDTO res=dozer.map(order,OrderDTO.class);
        return res;
    }

    public List<OrderDTO> getAll(){
        List<OrderDTO> res=new ArrayList<>();
        List <Order> orderList=orderRepository.findAll();
        if(orderList!=null)
        {
            for(Order order:orderList)
                res.add(dozer.map(order,OrderDTO.class));
        }
        return res;
    }

    public OrderDTO getById(String id){
        OrderDTO res=null;
        Optional<Order> order=orderRepository.findById(id);
        if(order.isPresent())
            res=dozer.map(order.get(),OrderDTO.class);
        return res;
    }
}
