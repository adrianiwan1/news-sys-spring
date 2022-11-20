package com.example.newssysspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "powiaty")
public class Powiaty {
    @Id
    @Column(name = "powiatyID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wojewodzstwo", nullable = false)
    private Wojewodzstwa wojewodzstwo;

    @Column(name = "nazwa", nullable = false, length = 25)
    private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Wojewodzstwa getWojewodzstwo() {
        return wojewodzstwo;
    }

    public void setWojewodzstwo(Wojewodzstwa wojewodzstwo) {
        this.wojewodzstwo = wojewodzstwo;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}