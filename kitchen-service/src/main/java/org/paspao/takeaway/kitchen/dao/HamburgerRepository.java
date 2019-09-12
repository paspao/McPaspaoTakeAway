package org.paspao.takeaway.kitchen.dao;

import org.paspao.takeaway.dto.type.HamburgerType;
import org.paspao.takeaway.kitchen.entity.Hamburger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
@Repository
public interface HamburgerRepository extends MongoRepository<Hamburger, String> {
    List<Hamburger> findByHamburgerTypeIs(HamburgerType hamburgerType);

}
