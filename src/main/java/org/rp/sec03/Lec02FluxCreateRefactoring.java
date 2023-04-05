package org.rp.sec03;

import org.rp.courseutil.Util;
import org.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer).subscribe(Util.subscriber());

        nameProducer.produce();
    }

}
