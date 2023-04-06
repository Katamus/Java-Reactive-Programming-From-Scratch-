package org.rp.sec04;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .map(integer -> 10/(5-integer))
                .onErrorReturn(-1)
                .onErrorResume(e -> fallBack())
                .onErrorContinue((throwable, o) -> {

                }) /* */
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallBack(){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100,200));
    }
}
