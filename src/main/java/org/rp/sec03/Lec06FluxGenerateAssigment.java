package org.rp.sec03;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

public class Lec06FluxGenerateAssigment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting : "+country);
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada"))
                synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
