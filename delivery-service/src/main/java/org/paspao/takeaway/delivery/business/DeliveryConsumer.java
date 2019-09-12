package org.paspao.takeaway.delivery.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.delivery.dao.DeliveryRepository;
import org.paspao.takeaway.delivery.entity.Delivery;
import org.paspao.takeaway.dto.OrderDTO;
import org.paspao.takeaway.dto.type.OrderStatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 12/09/19.
 */
@Service
public class DeliveryConsumer {

    private final static String TOPIC_DELIVERY="deliveryservice";

    private final static String TOPIC="orderservicecallback";

    private static final Logger logger = LoggerFactory.getLogger(DeliveryConsumer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @KafkaListener(topics = TOPIC_DELIVERY)
    public void consumeMessage(String content) {

        try {
            OrderDTO orderDTO = objectMapper.readValue(content, OrderDTO.class);
            Delivery delivery=new Delivery();
            delivery.setAddressDTO(orderDTO.getAddressDTO());
            delivery.setOrderId(orderDTO.getId());
            deliveryRepository.save(delivery);
            Thread.sleep(5000);
            orderDTO.setOrderStatus(OrderStatusType.DELIVERED);
            orderDTO.setStatusDescription("Delivered");
            kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(orderDTO));

        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        }


    }
}
