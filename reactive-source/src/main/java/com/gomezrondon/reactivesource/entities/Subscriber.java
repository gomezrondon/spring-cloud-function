package com.gomezrondon.reactivesource.entities;

import java.time.Instant;

public class Subscriber {

    private String id, firstName,lastName;
    private Instant subscriberDate;

    public Subscriber() {}

    public Subscriber(String id, String firstName, String lastName, Instant subscriberDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subscriberDate = subscriberDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subscriberDate=" + subscriberDate +
                '}';
    }
}
