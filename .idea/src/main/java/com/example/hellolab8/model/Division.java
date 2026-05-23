package com.example.hellolab8.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    // Un miembro actúa como presidente (relación OneToOne)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "president_id")
    private Member president;

    // Una división tiene muchos miembros
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    // Relación con la Asociación
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "association_id")
    private Association association;

    public Division() {}

    public Division(String name, String district) {
        this.name = name;
        this.district = district;
    }

    // Método helper para añadir miembros de forma bidireccional (Muy valorado en Ironhack)
    public void addMember(Member member) {
        members.add(member);
        member.setDivision(this);
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public Member getPresident() { return president; }
    public void setPresident(Member president) { this.president = president; }
    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }
    public Association getAssociation() { return association; }
    public void setAssociation(Association association) { this.association = association; }
}