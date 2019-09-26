package org.paspao.takeaway.kitchen.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.kitchen.bean.OrderDTO;
import org.paspao.takeaway.kitchen.port.IKithcenPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 18/09/19.
 */
@Service
public class KithenPublisher implements IKithcenPublisher {


    private final static String TOPIC_ORDER_CALLBACK ="orderservicecallback";

    private final static String TOPIC_DELIVERY="deliveryservice";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public void sendToOrderCallback(OrderDTO orderDTO) throws JsonProcessingException{
        kafkaTemplate.send(TOPIC_ORDER_CALLBACK,objectMapper.writeValueAsString(orderDTO));
    }

    @Override
    public void sendToDelivery(OrderDTO orderDTO) throws JsonProcessingException {
        kafkaTemplate.send(TOPIC_DELIVERY,objectMapper.writeValueAsString(orderDTO));
    }



}
