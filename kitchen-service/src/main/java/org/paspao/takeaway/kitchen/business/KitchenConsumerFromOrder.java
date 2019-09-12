package org.paspao.takeaway.kitchen.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 11/09/19.
 */
@Service
public class KitchenConsumerFromOrder  {

    private static final Logger logger = LoggerFactory.getLogger(KitchenConsumerFromOrder.class);

    private final static String TOPIC="orderservicecallback";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KitchenService kitchenService;

    @KafkaListener(topics = "orderservice")
    public void consumeMessage(String content) {

        try {
            OrderDTO orderDTO=objectMapper.readValue(content, OrderDTO.class);

            kitchenService.process(orderDTO);
            kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(orderDTO));


        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
