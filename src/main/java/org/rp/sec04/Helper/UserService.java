package org.rp.sec04.Helper;

import reactor.core.publisher.Flux;

public class UserService {

    public static Flux<User> getUsers(){
        return Flux.range(1,2)
                .map( User::new);
    }

}
