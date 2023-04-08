package org.rp.sec08;

import org.rp.courseutil.Util;
import org.rp.sec08.helper.AmericaAirLines;
import org.rp.sec08.helper.Emirates;
import org.rp.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericaAirLines.getFlights()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
