package org.paspao.takeaway.order.dao;

import org.paspao.takeaway.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {


}
