package org.rp.sec06;

import org.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec06parallel {

    public static void main(String[] args){

        Flux.range(1,1000)
                .parallel(10)
                .runOn(Schedulers.boundedElastic())
                //.doOnNext(i -> printThreadName("next " + i))
                .sequential()
                .subscribe(v -> printThreadName("sub "+ v));


       Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg+"\t\t:" + "thread : " + Thread.currentThread().getName());
    }



}
