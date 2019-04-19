package com.gomezrondon.reactivesink;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@EnableBinding(Sink.class)
public class MessageEndPoint {

    @Bean
    Consumer<Flux<String>> logIt(){
        return subscriberFlux-> subscriberFlux
                .onBackpressureDrop()
                .subscribe(System.out::println);
    }

/*  just for testing
    @StreamListener(target=Sink.INPUT)
    public void logItMethod(Flux<String> msgFlux) {
        msgFlux.subscribe(System.out::println);

    }
*/
}
