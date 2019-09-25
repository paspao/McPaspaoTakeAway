package org.paspao.takeaway.kitchen.port;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 25/09/19.
 */
public interface IKitchenMessaging {

    String ORDER_TOPIC="orderservice";

    @KafkaListener(topics = ORDER_TOPIC)
    void consumeMessage(String content);
}
