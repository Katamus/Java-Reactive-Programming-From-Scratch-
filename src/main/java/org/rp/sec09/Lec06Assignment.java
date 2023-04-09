package org.rp.sec09;

import org.rp.courseutil.Util;
import org.rp.sec09.assignment.OrderProcessor;
import org.rp.sec09.assignment.OrderService;
import org.rp.sec09.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {

    public static void main(String[] args){
        Map<String, Function<Flux<PurchaseOrder>,Flux<PurchaseOrder>>> map = Map.of(
          "Kids", OrderProcessor.kidsProcessing(),
            "Automotive", OrderProcessor.automotiveProcessing()
        );

        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p->set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

}
