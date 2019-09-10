package org.paspao.takeaway.order.port;

import io.swagger.annotations.ApiOperation;
import org.paspao.takeaway.dto.OrderDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
public interface OrderServicePort {

    @ApiOperation(value = "Create order", response = Void.class)
    @RequestMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    void create(@RequestBody OrderDTO request);

    @ApiOperation(value = "View order", response = Void.class)
    @RequestMapping(value = "view/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody OrderDTO view(@PathVariable Integer id);
}
