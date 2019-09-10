package org.paspao.takeaway.order.entity;

import org.paspao.takeaway.dto.OrderDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by <a href="mailto:pasquale.paola@gmail.com">Pasquale Paola</a> on 06/09/19.
 */
@Document
public class Order extends OrderDTO {

    @Override
    @Id
    public String getId() {
        return super.getId();
    }

}
