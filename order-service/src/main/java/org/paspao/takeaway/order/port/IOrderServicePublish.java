package org.paspao.takeaway.order.port;


import org.paspao.takeaway.order.bean.OrderDTO;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 09/09/19.
 */
public interface IOrderServicePublish {
    void sendOrder(OrderDTO orderDTO);
}
