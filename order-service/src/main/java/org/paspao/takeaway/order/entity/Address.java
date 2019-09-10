package org.paspao.takeaway.order.entity;

import org.paspao.takeaway.dto.AddressDTO;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 09/09/19.
 */
public class Address extends AddressDTO {

    private String street;
    private String number;

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street=street;
    }

    @Override
    public void setNumber(String number) {
        this.number=number;
    }

    @Override
    public String getNumber() {
        return number;
    }
}
