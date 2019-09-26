package org.paspao.takeaway.kitchen.api;

import io.swagger.annotations.Api;
import org.paspao.takeaway.kitchen.bean.HamburgerDTO;
import org.paspao.takeaway.kitchen.business.KitchenService;
import org.paspao.takeaway.kitchen.port.IKitchenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
@RestController
@RequestMapping("/kitchen/")
@Api(tags = "KitchenServices")
public class KitchenApi implements IKitchenApi {

    @Autowired
    private KitchenService kitchenService;

    @Override
    public List<HamburgerDTO> status() {
        return kitchenService.getStatus();
    }

    @Override
    public void addHamburger(HamburgerDTO hamburgerDTO) {
        kitchenService.addHamburger(hamburgerDTO);
    }
}
