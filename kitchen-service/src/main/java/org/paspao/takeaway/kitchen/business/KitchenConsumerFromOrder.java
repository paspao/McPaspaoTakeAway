package org.paspao.takeaway.kitchen.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.paspao.takeaway.kitchen.bean.OrderDTO;
import org.paspao.takeaway.kitchen.bean.type.OrderStatusType;
import org.paspao.takeaway.kitchen.port.IKitchenMessaging;
import org.paspao.takeaway.kitchen.port.IKithcenPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 11/09/19.
 */
@Service
public class KitchenConsumerFromOrder  implements IKitchenMessaging {

    private static final Logger logger = LoggerFactory.getLogger(KitchenConsumerFromOrder.class);

    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IKithcenPublisher kithcenPublisher;

    @Override
    public void consumeMessage(String content) {

        try {
            OrderDTO orderDTO=objectMapper.readValue(content, OrderDTO.class);

            kitchenService.process(orderDTO);


            logger.info("Start cooking for order id "+orderDTO.getId()+" start");
            Thread.sleep(5000);
            logger.info("Packaging start");
            orderDTO.setOrderStatus(OrderStatusType.PACKAGING);
            orderDTO.setStatusDescription("Order in packaging");

            kithcenPublisher.sendToOrderCallback(orderDTO);
            logger.info("Callback to order service sent");
            kithcenPublisher.sendToDelivery(orderDTO);
            logger.info("Order id "+orderDTO.getId()+" sent to delivery");
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
