package org.paspao.takeaway.kitchen.dao;

import org.paspao.takeaway.kitchen.entity.Hamburger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
@Repository
public interface HamburgerRepository extends MongoRepository<Hamburger, String> {
}
