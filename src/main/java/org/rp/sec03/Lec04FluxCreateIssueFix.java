package org.rp.sec03;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {

            String country;
            do {
                country = Util.faker().country().name();

                System.out.println("emitting : "+country);

                fluxSink.next(country);
            }while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
        .take(3)
        .subscribe(Util.subscriber());
    }

}
