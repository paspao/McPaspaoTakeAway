package org.paspao.takeaway.dto.type;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 09/09/19.
 */
public enum HamburgerType {
    ANGUS("ANGUS"),SCOTTONA("SCOTTONA"),CHIANINA("CHIANINA"),KOBE("KOBE"),VITELLONE("VITELLONE");

    private String description;

    HamburgerType(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
