package org.paspao.takeaway.dto;

import org.paspao.takeaway.dto.type.HamburgerType;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 09/09/19.
 */
public class HamburgerDTO {

    private HamburgerType hamburgerType;

    private int quantity;

    public HamburgerDTO(){

    }

    public HamburgerDTO(HamburgerType type,int quantity){
        this.quantity=quantity;
        this.hamburgerType=type;
    }

    public HamburgerType getHamburgerType() {
        return hamburgerType;
    }

    public void setHamburgerType(HamburgerType hamburgerType) {
        this.hamburgerType = hamburgerType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
