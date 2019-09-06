package org.paspao.takeaway.order.business;

import org.paspao.takeaway.order.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by <a href="mailto:pasquale.paola@eng.it">Pasquale Paola</a> on 06/09/19.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(){

    }
}
