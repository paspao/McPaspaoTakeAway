package org.paspao.takeaway.delivery.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.paspao.takeaway.dto.OrderDTO;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 18/09/19.
 */
public interface IDeliveryPublisher {

    void sendToOrderCallback(OrderDTO orderDTO) throws JsonProcessingException;
}
