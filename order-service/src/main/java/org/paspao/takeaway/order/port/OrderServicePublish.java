package org.paspao.takeaway.order.port;

import org.paspao.takeaway.dto.OrderDTO;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 09/09/19.
 */
public interface OrderServicePublish {
    void sendOrder(OrderDTO orderDTO);
}
