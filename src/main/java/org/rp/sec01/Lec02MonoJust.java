package org.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(integer -> System.out.println("Received : "+integer));

    }

}
