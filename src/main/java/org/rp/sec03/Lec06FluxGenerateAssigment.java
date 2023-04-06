package org.rp.sec03;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssigment {

    public static void main(String[] args) {

        // canada
        // max = 10
        // subcriber cancels - exit
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {

            String country = Util.faker().country().name();
            System.out.println("emitting : "+country);
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada") || atomicInteger.incrementAndGet() > 3)
                synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
