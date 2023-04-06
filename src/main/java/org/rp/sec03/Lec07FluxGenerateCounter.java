package org.rp.sec03;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(() -> 1,
                (counter, synchronousSink) -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if(counter >=10 || country.toLowerCase().equals("canada")){
                        synchronousSink.complete();
                    }
                    return counter + 1;
                })
                .subscribe(Util.subscriber());
    }
}
