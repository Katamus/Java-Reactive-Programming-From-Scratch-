package org.rp.sec04;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(integer -> integer > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,12);
    }
}
