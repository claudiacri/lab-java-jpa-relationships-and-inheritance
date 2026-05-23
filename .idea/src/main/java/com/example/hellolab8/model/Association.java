package com.example.hellolab8.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

       @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Division> divisions = new ArrayList<>();

    public Association() {}

    public Association(String name) {
        this.name = name;
    }

    // Método helper para añadir divisiones de forma bidireccional
    public void addDivision(Division division) {
        divisions.add(division);
        division.setAssociation(this);
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Division> getDivisions() { return divisions; }
    public void setDivisions(List<Division> divisions) { this.divisions = divisions; }
}