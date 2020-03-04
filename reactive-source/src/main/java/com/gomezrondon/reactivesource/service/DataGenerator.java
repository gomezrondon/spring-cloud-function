package com.gomezrondon.reactivesource.service;

import com.gomezrondon.reactivesource.entities.Subscriber;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.function.Supplier;

@EnableBinding(Source.class)
public class DataGenerator {

    private final SubscriberGenerator generator;

    public DataGenerator(SubscriberGenerator generator) {
        this.generator = generator;
    }

    @Bean
    Supplier<Flux<Subscriber>> send(){
        return () ->Flux.interval(Duration.ofSeconds(5))
                .onBackpressureDrop()
                .map(x -> generator.generate())
                .log();
    }

}
