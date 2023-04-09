package org.rp.sec10;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec01Repeat {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        getIntegers()
                .repeat(() -> atomicInteger.get() < 14)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .doOnSubscribe(subscription -> System.out.println("Subcribed"))
                .doOnComplete(() -> System.out.println("Completed"))
                .map(i -> atomicInteger.getAndIncrement());
    }

}
