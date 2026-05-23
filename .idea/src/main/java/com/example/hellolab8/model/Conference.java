package com.example.hellolab8.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conferences")
@PrimaryKeyJoinColumn(name = "event_id")
public class Conference extends Event {

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "conference_speakers",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers = new ArrayList<>();

    public Conference() {}

    public Conference(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }

    // Metodo helper per gli speaker
    public void addSpeaker(Speaker speaker) {
        this.speakers.add(speaker);
        speaker.getConferences().add(this);
    }

    // Getters e Setters
    public List<Speaker> getSpeakers() { return speakers; }
    public void setSpeakers(List<Speaker> speakers) { this.speakers = speakers; }
}