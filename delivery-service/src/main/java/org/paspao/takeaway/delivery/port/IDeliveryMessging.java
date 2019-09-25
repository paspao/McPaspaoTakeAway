package org.paspao.takeaway.delivery.port;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 25/09/19.
 */
public interface IDeliveryMessging {

    String TOPIC_DELIVERY="deliveryservice";

    @KafkaListener(topics = TOPIC_DELIVERY)
    void consumeMessage(String content);
}
