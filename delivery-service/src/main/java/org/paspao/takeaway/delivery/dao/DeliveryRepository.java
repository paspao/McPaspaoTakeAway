package org.paspao.takeaway.delivery.dao;

import org.paspao.takeaway.delivery.entity.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 12/09/19.
 */
@Repository
public interface DeliveryRepository extends MongoRepository<Delivery,String> {
}
