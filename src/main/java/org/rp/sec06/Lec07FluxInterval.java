package org.rp.sec06;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .doOnNext(aLong -> printThreadName("interval"))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(aLong -> printThreadName("subscribeOn"))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static void printThreadName(String msg){
        System.out.println(msg+"\t\t:" + "thread : " + Thread.currentThread().getName());
    }
}
