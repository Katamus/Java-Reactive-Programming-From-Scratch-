package org.rp.sec08;

import org.rp.courseutil.Util;
import org.rp.sec08.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {

        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber());

        nameGenerator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("jake"));

    }

}
