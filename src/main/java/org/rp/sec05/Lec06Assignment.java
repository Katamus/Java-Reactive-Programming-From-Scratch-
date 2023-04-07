package org.rp.sec05;

import org.rp.courseutil.Util;
import org.rp.sec05.assignment.InventoryService;
import org.rp.sec05.assignment.OrderService;
import org.rp.sec05.assignment.RenueveService;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RenueveService renueveService = new RenueveService();
        InventoryService inventoryService = new InventoryService();

        // revenue ad inv - observe the order stream
        orderService.orderStream().subscribe(renueveService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));

        renueveService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);

    }
}
