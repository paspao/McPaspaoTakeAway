package org.paspao.takeaway.kitchen.entity;

import org.paspao.takeaway.kitchen.bean.type.HamburgerType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 10/09/19.
 */
@Document
public class Hamburger  {

    @Id
    private String id;
    private HamburgerType hamburgerType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HamburgerType getHamburgerType() {
        return hamburgerType;
    }

    public void setHamburgerType(HamburgerType hamburgerType) {
        this.hamburgerType = hamburgerType;
    }
}
