package org.rp.sec04;

import org.rp.courseutil.Util;
import org.rp.sec04.Helper.OrderService;
import org.rp.sec04.Helper.UserService;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))// mono / flux
                //.filter(p-> p. > 10)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
