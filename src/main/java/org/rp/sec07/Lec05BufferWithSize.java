package org.rp.sec07;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05BufferWithSize {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Push : "+i);
                        Util.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureBuffer(50,o -> System.out.println("Dropped : "+ o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i->{
                    Util.sleepMillis(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);

    }
}
