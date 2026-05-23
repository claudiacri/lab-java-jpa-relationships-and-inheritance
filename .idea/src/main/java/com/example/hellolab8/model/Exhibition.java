package com.example.hellolab8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "exhibitions")
@PrimaryKeyJoinColumn(name = "event_id")
public class Exhibition extends Event {

    public Exhibition() {}

    public Exhibition(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }
}