package org.rp.sec06;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {

    public static void main(String[] args){
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Util.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next " + i));

        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
                .publishOn(Schedulers.parallel())
                .subscribe(v -> printThreadName("sub "+ v));




        Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg+"\t\t:" + "thread : " + Thread.currentThread().getName());
    }



}
