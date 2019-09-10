package org.paspao.takeaway.dto;

import org.paspao.takeaway.dto.type.CookingType;
import org.paspao.takeaway.dto.type.HamburgerType;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 09/09/19.
 */
public class HamburgerDTO {

    private HamburgerType hamburgerType;
    private CookingType cookingType;

    public HamburgerType getHamburgerType() {
        return hamburgerType;
    }

    public void setHamburgerType(HamburgerType hamburgerType) {
        this.hamburgerType = hamburgerType;
    }

    public CookingType getCookingType() {
        return cookingType;
    }

    public void setCookingType(CookingType cookingType) {
        this.cookingType = cookingType;
    }
}
