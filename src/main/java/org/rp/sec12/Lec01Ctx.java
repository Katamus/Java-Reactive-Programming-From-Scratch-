package org.rp.sec12;

import org.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Ctx {
    public static void main(String[] args) {
        getWelcomeMessage()
        .contextWrite(context -> context.put("user",context.get("user").toString().toUpperCase()))
        .contextWrite(Context.of("user","sam"))
        .subscribe(Util.subscriber());
    }

    public static Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(contextView -> {
            if(contextView.hasKey("user")){
                return Mono.just("Welcome "+contextView.get("user"));
            }else{
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}
