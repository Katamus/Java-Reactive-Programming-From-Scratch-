package org.rp.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rp.sec09.helper.BookOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec05VirtualTimeTest {

    @Test
    public void test1() {
        StepVerifier.withVirtualTime(()->timeConsumingFlux())
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a","2a","3a","4a")
                .verifyComplete();
    }

    @Test
    public void test2() {
        StepVerifier.withVirtualTime(()->timeConsumingFlux())
                .expectSubscription() // sub is an event
                .expectNoEvent(Duration.ofSeconds(4))
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a","2a","3a","4a")
                .verifyComplete();
    }

    private Flux<String> timeConsumingFlux(){
        return Flux.range(1,4)
                .delayElements(Duration.ofSeconds(5))
                .map(i -> i+ "a");
    }

}
