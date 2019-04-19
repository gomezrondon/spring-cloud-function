package com.gomezrondon.reactiveprocessor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@EnableBinding(Processor.class)
public class MessageProcessor {



    @Bean
    Function<Subscriber, Subscriber> upperCaseIt() {
        return s -> new Subscriber(s.getId(),
                s.getFirstName().toUpperCase(),
                s.getLastName().toUpperCase(),
                s.getSubscriberDate());
    }

    @Bean
    Function<Flux<Subscriber>, Flux<Subscriber>> reverseIt() {
        return sFlux -> sFlux.map(s -> new Subscriber(s.getId(),
                reverse(s.getFirstName()),
                reverse(s.getLastName()),
                s.getSubscriberDate()));
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }



}
