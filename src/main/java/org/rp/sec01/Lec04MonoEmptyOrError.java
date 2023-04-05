package org.rp.sec01;

import org.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    private static Mono<String> userRepository(int userId){
        // 1
        if(userId == 1){
            return Mono.just(Util.faker().name().firstName());
        }else if(userId == 2){
            return Mono.empty();
        }else
            return Mono.error(new RuntimeException("Not in the allowed range"));
    }
    public static void main(String[] args) {
        userRepository(20)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
