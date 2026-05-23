package com.example.hellolab8.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED) // Strategia di ereditarietà JOINED
public abstract class Event { // Astratta perché non creiamo mai un "Evento" generico

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate date;
    private Integer duration;
    private String location;

    // Relazione Many-to-Many con Guest: un ospite può andare a molti eventi, un evento ha molti ospiti
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "event_guests",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests = new ArrayList<>();

    public Event() {}

    public Event(String title, LocalDate date, Integer duration, String location) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
    }

    // Metodo helper per associare gli ospiti
    public void addGuest(Guest guest) {
        this.guests.add(guest);
        guest.getEvents().add(this);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public List<Guest> getGuests() { return guests; }
    public void setGuests(List<Guest> guests) { this.guests = guests; }
}
