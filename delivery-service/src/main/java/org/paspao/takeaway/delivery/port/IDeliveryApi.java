package org.paspao.takeaway.delivery.port;

import io.swagger.annotations.ApiOperation;
import org.paspao.takeaway.dto.DeliveryDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 12/09/19.
 */
public interface IDeliveryApi {


    @ApiOperation(value = "View delivery status", response = DeliveryDTO.class,responseContainer = "list")
    @RequestMapping(value = "status", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    List<DeliveryDTO> status();
}
