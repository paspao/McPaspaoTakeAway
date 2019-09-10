package org.paspao.takeaway.kitchen.business;

import org.paspao.takeaway.dto.HamburgerDTO;
import org.paspao.takeaway.dto.type.HamburgerType;
import org.paspao.takeaway.kitchen.dao.HamburgerRepository;
import org.paspao.takeaway.kitchen.entity.Hamburger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
@Service
public class KitchenService {

    @Autowired
    private HamburgerRepository hamburgerRepository;

    public void addHamburger(HamburgerDTO hamburgerDTO)
    {
        for(int i=0;i<hamburgerDTO.getQuantity();i++)
        {
            Hamburger hamburger=new Hamburger();
            hamburger.setHamburgerType(hamburgerDTO.getHamburgerType());
            hamburgerRepository.save(hamburger);
        }
    }

    public List<HamburgerDTO> getStatus(){
        List<HamburgerDTO> list=new ArrayList<>();
        List<Hamburger> hamburgerList=hamburgerRepository.findAll();
        if(hamburgerList!=null) {
            Map<HamburgerType,Integer> hamburgerTypeSizeMap=new HashMap<>();
            for (Hamburger hamburger : hamburgerList) {
                Integer currentSize=null;
                if((currentSize=hamburgerTypeSizeMap.get(hamburger.getHamburgerType()))!=null)
                    currentSize = currentSize.intValue() + 1;
                else
                    currentSize=1;
                hamburgerTypeSizeMap.put(hamburger.getHamburgerType(),currentSize);
            }
            for(Map.Entry<HamburgerType,Integer> entry:hamburgerTypeSizeMap.entrySet())
                list.add(new HamburgerDTO(entry.getKey(),entry.getValue()));
        }
        return list;
    }
}
