package org.rp.sec10;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec03RetryWhen {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .doOnSubscribe(subscription -> System.out.println("Subcribed"))
                .doOnComplete(() -> System.out.println("Completed"))
                .map(i -> i/(Util.faker().random().nextInt(1,5) > 3 ? 0 : 1))
                .doOnError(err-> System.out.println("--error"));
    }

}
