package org.paspao.takeaway.dto;

import java.util.List;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
public class OrderDTO {

    private String id;

    private List<HamburgerDTO> hamburgerList;

    private AddressDTO addressDTO;
    private float price;

    public List<HamburgerDTO> getHamburgerList() {
        return hamburgerList;
    }

    public void setHamburgerList(List<HamburgerDTO> hamburgerList) {
        this.hamburgerList = hamburgerList;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
