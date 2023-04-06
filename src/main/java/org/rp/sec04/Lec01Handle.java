package org.rp.sec04;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.BiConsumer;

public class Lec01Handle {
    public static void main(String[] args) {
        Flux.range(1,20)
                .handle(biConsumer())
                .subscribe(Util.subscriber());
    }


    static public BiConsumer<Integer, SynchronousSink<Integer>> biConsumer () {
        return new BiConsumer<Integer, SynchronousSink<Integer>>() {
            @Override
            public void accept(Integer integer, SynchronousSink<Integer> integerSynchronousSink) {
                if(integer == 7)
                    integerSynchronousSink.complete();
                else
                    integerSynchronousSink.next(integer);
            }
        };
    }
}
