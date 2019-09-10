package org.paspao.takeaway.order.api;

import io.swagger.annotations.Api;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.order.business.OrderService;
import org.paspao.takeaway.order.port.OrderServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@RestController
@RequestMapping("/order/")
@Api(tags = "OrderServices")
public class OrderApi implements OrderServicePort {

    @Autowired
    private OrderService orderService;

    @Override
    public void create(OrderDTO request) {
        orderService.createOrder(request);
    }

    @Override
    public OrderDTO view(Integer id) {
        return null;
    }
}
