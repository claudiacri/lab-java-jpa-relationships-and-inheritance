package com.example.hellolab8.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer presentationDuration;

    @ManyToMany(mappedBy = "speakers", fetch = FetchType.LAZY)
    private List<Conference> conferences = new ArrayList<>();

    public Speaker() {}

    public Speaker(String name, Integer presentationDuration) {
        this.name = name;
        this.presentationDuration = presentationDuration;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getPresentationDuration() { return presentationDuration; }
    public void setPresentationDuration(Integer presentationDuration) { this.presentationDuration = presentationDuration; }
    public List<Conference> getConferences() { return conferences; }
    public void setConferences(List<Conference> conferences) { this.conferences = conferences; }
}
