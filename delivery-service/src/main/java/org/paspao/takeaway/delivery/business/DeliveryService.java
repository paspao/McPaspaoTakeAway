package org.paspao.takeaway.delivery.business;

import org.dozer.DozerBeanMapper;
import org.paspao.takeaway.delivery.bean.DeliveryDTO;
import org.paspao.takeaway.delivery.dao.DeliveryRepository;
import org.paspao.takeaway.delivery.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 12/09/19.
 */
@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<DeliveryDTO> getAll()
    {
        List<Delivery> deliveryList  =deliveryRepository.findAll();
        List<DeliveryDTO> res=null;
        if(deliveryList!=null)
        {
            res=new ArrayList<>();
            for(Delivery delivery:deliveryList)
            {
                DeliveryDTO deliveryDTO=dozerBeanMapper.map(delivery,DeliveryDTO.class);
                res.add(deliveryDTO);
            }
        }
        return res;
    }
}
