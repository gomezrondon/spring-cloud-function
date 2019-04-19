package com.gomezrondon.reactivesource.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gomezrondon.reactivesource.entities.Subscriber;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class SubscriberGenerator {

    private List<String> firstNames =  Arrays.asList("Alberto,Bonaire,Carlos,Diana,Echo,Fabio".split(","));
    private List<String> lastNames =  Arrays.asList("Alvarez,Bolivar,Colorado,D'Angelo,Epic,Fibonachi".split(","));
    private Random rnd = new Random();
    private int i,j;

    public Subscriber generate(){
        i=rnd.nextInt(firstNames.size());
        j=rnd.nextInt(lastNames.size());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Subscriber subscriber = new Subscriber(UUID.randomUUID().toString(),
                firstNames.get(i),
                lastNames.get(j),
                Instant.now());

        String json = null;
        try {
            json = mapper.writeValueAsString(subscriber);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return subscriber;
    }
}
