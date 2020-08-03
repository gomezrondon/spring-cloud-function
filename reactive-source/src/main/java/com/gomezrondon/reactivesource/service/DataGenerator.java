package com.gomezrondon.reactivesource.service;

import com.gomezrondon.reactivesource.entities.Subscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.function.Supplier;

@EnableBinding(Source.class)
public class DataGenerator {

    private final SubscriberGenerator generator;

    @Value("${function.generator.interval:5}")
    private Integer duration;

    public DataGenerator(SubscriberGenerator generator) {
        this.generator = generator;
    }

    @Bean
    Supplier<Flux<Subscriber>> send(){
        return () ->Flux.interval(Duration.ofSeconds(duration))
                .onBackpressureDrop()
                .map(x -> generator.generate())
                .log();
    }




}
