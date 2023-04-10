package org.rp.sec11;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {

    public static void main(String[] args) {
        // Mono 1 value / empty / error
        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));

        sink.emitValue("h1",(signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        });

        sink.emitValue("hello",(signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        });
    }

}
