package org.paspao.takeaway.order.api;

import io.swagger.annotations.Api;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.order.business.OrderService;
import org.paspao.takeaway.order.port.IOrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@RestController
@RequestMapping("/order/")
@Api(tags = "OrderServices")
public class IOrderApi implements IOrderServiceApi {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO create(OrderDTO request) {
        return orderService.createOrder(request);
    }

    @Override
    public OrderDTO view(String id) {
        return orderService.getById(id);
    }

    @Override
    public List<OrderDTO> viewAll() {
        return orderService.getAll();
    }


}
