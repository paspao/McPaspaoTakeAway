package org.paspao.takeaway.order.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.order.port.OrderServicePublish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
@Service
public class OrderServicePublisher implements OrderServicePublish {

    private static final Logger logger = LoggerFactory.getLogger(OrderServicePublisher.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final static String TOPIC="orderservice";

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void sendOrder(OrderDTO orderDTO) {
        try {
            kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(orderDTO));
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
