package com.example.newssysspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "wojewodzstwa")
public class Wojewodzstwa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wojewodzstwaID", nullable = false)
    private Integer id;

    @Column(name = "nazwa", nullable = false, length = 25)
    private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}