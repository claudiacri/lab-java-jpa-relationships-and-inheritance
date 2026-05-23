package com.example.hellolab8.model;


import com.example.hellolab8.enums.Status;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING) // Guarda el texto (ACTIVE/LAPSED) en la DB en vez de números
    private Status status;

    private LocalDate renewalDate;

    // Relación ManyToOne hacia Division (Muchos miembros pertenecen a una división)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private Division division;

    public Member() {}

    public Member(String name, Status status, LocalDate renewalDate) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDate getRenewalDate() { return renewalDate; }
    public void setRenewalDate(LocalDate renewalDate) { this.renewalDate = renewalDate; }
    public Division getDivision() { return division; }
    public void setDivision(Division division) { this.division = division; }
}