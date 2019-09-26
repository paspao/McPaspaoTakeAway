package org.paspao.takeaway.kitchen.port;

import io.swagger.annotations.ApiOperation;
import org.paspao.takeaway.kitchen.bean.HamburgerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
public interface IKitchenApi {


    @ApiOperation(value = "View kitchen status", response = HamburgerDTO.class,responseContainer = "list")
    @RequestMapping(value = "status", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    List<HamburgerDTO> status();

    @ApiOperation(value = "Add hamburger", response = Void.class)
    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    void addHamburger(HamburgerDTO hamburgerDTO);
}
