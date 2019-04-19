package com.gomezrondon.reactivesink.entities;

import java.time.Instant;

public class Subscriber {

    private String id,fristName,lastName;
    private Instant subscriberDate;

    public Subscriber(String id, String fristName, String lastName, Instant subscriberDate) {
        this.id = id;
        this.fristName = fristName;
        this.lastName = lastName;
        this.subscriberDate = subscriberDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getSubscriberDate() {
        return subscriberDate;
    }

    public void setSubscriberDate(Instant subscriberDate) {
        this.subscriberDate = subscriberDate;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id='" + id + '\'' +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subscriberDate=" + subscriberDate +
                '}';
    }
}
