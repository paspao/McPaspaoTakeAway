package org.paspao.takeaway.delivery.api;

import io.swagger.annotations.Api;
import org.paspao.takeaway.delivery.business.DeliveryService;
import org.paspao.takeaway.delivery.port.IDeliveryApi;
import org.paspao.takeaway.dto.DeliveryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 12/09/19.
 */
@RestController
@RequestMapping("/delivery/")
@Api(tags = "DeliveryServices")
public class DeliveryApi implements IDeliveryApi {

    @Autowired
    private DeliveryService deliveryService;

    @Override
    public List<DeliveryDTO> status() {
        return deliveryService.getAll();
    }
}
