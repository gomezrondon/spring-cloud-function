package com.gomezrondon.reactivesource.service;

import com.gomezrondon.reactivesource.entities.Subscriber;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.time.Duration;

@EnableBinding(Source.class)
public class DataGenerator {

    private final SubscriberGenerator generator;

    public DataGenerator(SubscriberGenerator generator) {
        this.generator = generator;
    }

    @StreamEmitter
    @Output(Source.OUTPUT)
    @PostConstruct
    Flux<Subscriber> send(){
        return Flux.interval(Duration.ofSeconds(5))
                .onBackpressureDrop()
                .map(x -> generator.generate())
                .log();
    }

}
