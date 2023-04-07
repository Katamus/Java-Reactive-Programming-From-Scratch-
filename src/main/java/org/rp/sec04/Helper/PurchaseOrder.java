package org.rp.sec04.Helper;

import lombok.Data;
import lombok.ToString;
import org.rp.courseutil.Util;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private String price;
    private int userId;
    public PurchaseOrder(int userId){
        this.userId = userId;
        this.item = Util.faker().commerce().productName();
        this.price = Util.faker().commerce().price();
    }
}
