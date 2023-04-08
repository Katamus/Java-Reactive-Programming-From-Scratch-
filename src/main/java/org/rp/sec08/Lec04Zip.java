package org.rp.sec08;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(getBody(),getEngine(),getTires())
                .subscribe(Util.subscriber());
    }

    private static Flux<String> getBody(){
        return Flux.range(1,5)
                .map(integer -> "body");
    }

    private static Flux<String> getEngine(){
        return Flux.range(1,2)
                .map(integer -> "body");
    }

    private static Flux<String> getTires(){
        return Flux.range(1,6)
                .map(integer -> "tires");
    }
}
