package org.rp.sec04;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(integer -> integer > 10)
                .switchIfEmpty(fallBack())
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10);
    }

    public static Flux<Integer> fallBack() {
        return Flux.range(20,5);
    }

}
