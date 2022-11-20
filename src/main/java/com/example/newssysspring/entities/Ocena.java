package com.example.newssysspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "ocena")
public class Ocena {
    @Id
    @Column(name = "ocena_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownicy uzytkownik;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artykul_id", nullable = false)
    private Artykuly artykul;

    @Column(name = "ocena_ocena", nullable = false)
    private Integer ocenaOcena;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uzytkownicy getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownicy uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Artykuly getArtykul() {
        return artykul;
    }

    public void setArtykul(Artykuly artykul) {
        this.artykul = artykul;
    }

    public Integer getOcenaOcena() {
        return ocenaOcena;
    }

    public void setOcenaOcena(Integer ocenaOcena) {
        this.ocenaOcena = ocenaOcena;
    }

}