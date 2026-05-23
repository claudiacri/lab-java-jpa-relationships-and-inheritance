package com.example.hellolab8.model;

import com.example.hellolab8.enums.GuestStatus;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToMany(mappedBy = "guests", fetch = FetchType.LAZY)
    private List<Event> events = new ArrayList<>();

    public Guest() {}

    public Guest(String name, GuestStatus status) {
        this.name = name;
        this.status = status;
    }
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public GuestStatus getStatus() { return status; }
    public void setStatus(GuestStatus status) { this.status = status; }
    public List<Event> getEvents() { return events; }
    public void setEvents(List<Event> events) { this.events = events; }
}