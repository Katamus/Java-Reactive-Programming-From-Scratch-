package org.rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class example {

    public static void main(String[] args) {
        Flux.range(1,20).subscribeWith(new Subscriber<Integer>() {

            Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(21);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("El valor es "+integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError : " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onClomplete");
            }
        });
    }
}
