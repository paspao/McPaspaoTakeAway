package org.paspao.takeaway.order.port;

import org.paspao.takeaway.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by <a href="mailto:pasquale.paola@eng.it">Pasquale Paola</a> on 06/09/19.
 */
public interface OrderServicePort {
    @PostMapping("create")
    void create(@RequestBody OrderDTO request);
    @GetMapping("view/{id}")
    OrderDTO view(@PathVariable Integer id);
}
