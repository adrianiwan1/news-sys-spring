package com.example.newssysspring.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "komentarze")
public class Komentarze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "komentarzeID", nullable = false)
    private Integer id;

    @Column(name = "data", nullable = false)
    private Instant data;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uzytkownicyID", nullable = false)
    private Uzytkownicy uzytkownicyID;

    @Column(name = "ocena", nullable = false)
    private Integer ocena;

    @Column(name = "tresc", nullable = false, length = 16383)
    private String tresc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artykul", nullable = false)
    private Artykuly artykul;

    @Column(name = "usuniety", nullable = false)
    private Boolean usuniety = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Uzytkownicy getUzytkownicyID() {
        return uzytkownicyID;
    }

    public void setUzytkownicyID(Uzytkownicy uzytkownicyID) {
        this.uzytkownicyID = uzytkownicyID;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Artykuly getArtykul() {
        return artykul;
    }

    public void setArtykul(Artykuly artykul) {
        this.artykul = artykul;
    }

    public Boolean getUsuniety() {
        return usuniety;
    }

    public void setUsuniety(Boolean usuniety) {
        this.usuniety = usuniety;
    }

}