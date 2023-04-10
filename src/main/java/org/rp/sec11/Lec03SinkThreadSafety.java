package org.rp.sec11;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Lec03SinkThreadSafety {

    public static void main(String[] args) {
        // handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        // handel through which subcribers will receive items
        Flux<Object> flux = sink.asFlux();

        List<Object> list = new ArrayList<>();

        flux.subscribe(list::add);
    /*
        for (int i = 0; i < 1000; i++) {
            final int j = 1;
            CompletableFuture.runAsync(() -> {
                sink.tryEmitNext(j);
            });
        }
        */

        for (int i = 0; i < 1000; i++) {
            final int j = 1;
            CompletableFuture.runAsync(() -> {
                sink.emitNext(j,(signalType, emitResult) -> true);
            });
        }

        Util.sleepSeconds(3);
        System.out.println(list.size());
    }

}
