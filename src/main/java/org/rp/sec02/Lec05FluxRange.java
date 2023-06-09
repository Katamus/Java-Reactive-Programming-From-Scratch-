package org.rp.sec02;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(3,10)
                .log()
                .map(integer -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
