package org.rp.sec1;

import org.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        //Publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(integer -> integer/1);

        // 1
        //mono.subscribe();

        // 2
        mono.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete()
                );
    }
}
