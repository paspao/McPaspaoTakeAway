package org.paspao.takeaway.kitchen.business;

import org.paspao.takeaway.kitchen.bean.HamburgerDTO;
import org.paspao.takeaway.kitchen.bean.OrderDTO;
import org.paspao.takeaway.kitchen.bean.type.HamburgerType;
import org.paspao.takeaway.kitchen.bean.type.OrderStatusType;
import org.paspao.takeaway.kitchen.dao.HamburgerRepository;
import org.paspao.takeaway.kitchen.entity.Hamburger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(KitchenService.class);


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

    public synchronized void process(OrderDTO orderDTO)
    {


        List<HamburgerDTO> hamburgerDTOList= orderDTO.getHamburgerList();
        List<Hamburger> candidatesHamburger=new ArrayList<>();
        for(HamburgerDTO hDto:hamburgerDTOList)
        {
            List<Hamburger> hamburgerList= hamburgerRepository.findByHamburgerTypeIs(hDto.getHamburgerType());
            logger.info("List pippo "+hamburgerList.size());
            if(hamburgerList!=null&&hamburgerList.size()>=hDto.getQuantity())
            {

                int i=0;
                for(Hamburger hamburger:hamburgerList) {
                    ++i;
                    candidatesHamburger.add(hamburger);
                    if(i==hDto.getQuantity())
                        break;

                }
            }
            else {

                orderDTO.setOrderStatus(OrderStatusType.ABORTED);
                orderDTO.setStatusDescription(hDto.getHamburgerType().getDescription()+" finished, only "+hamburgerList.size()+" in the fridge");
                return;
            }
        }
        orderDTO.setOrderStatus(OrderStatusType.COOKING);
        for(Hamburger hamburger:candidatesHamburger)
        {
                hamburgerRepository.deleteById(hamburger.getId());
        }

    }
}
