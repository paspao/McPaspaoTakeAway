package org.paspao.takeaway.order.port;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 25/09/19.
 */
public interface IOrderMessaging {

    String TOPIC_ORDER_CALLBACK ="orderservicecallback";

    @KafkaListener(topics = TOPIC_ORDER_CALLBACK)
    void callback(String message);
}
