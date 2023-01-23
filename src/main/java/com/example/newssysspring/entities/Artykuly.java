package com.example.newssysspring.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "artykuly")
public class Artykuly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artykulyID", nullable = false)
    private Integer id;

    @Column(name = "dataDodania", nullable = false)
    private Instant dataDodania;

    @Column(name = "dataPublikacji", nullable = false)
    private Instant dataPublikacji;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "autor", nullable = false)
    private Uzytkownicy autor;

    @Column(name = "tytul", nullable = false)
    private String tytul;

    @Column(name = "tresc", nullable = false, length = 16383)
    private String tresc;

    @Column(name = "obrazek", nullable = false)
    private String obrazek;

    @Column(name = "zbanowany", nullable = false)
    private Integer zbanowany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Instant dataDodania) {
        this.dataDodania = dataDodania;
    }

    public Instant getDataPublikacji() {
        return dataPublikacji;
    }

    public void setDataPublikacji(Instant dataPublikacji) {
        this.dataPublikacji = dataPublikacji;
    }

    public Uzytkownicy getAutor() {
        return autor;
    }

    public void setAutor(Uzytkownicy autor) {
        this.autor = autor;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getObrazek() {
        String path = obrazek;
        if(obrazek != null && path.contains("image")){
        path = path.substring(path.indexOf("image"));
        }
        return path;
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }

    public Integer getZbanowany() {
        return zbanowany;
    }

    public void setZbanowany(Integer zbanowany) {
        this.zbanowany = zbanowany;
    }

    public String getLessTresc(){ return tresc.length() < 100 ? tresc : tresc.substring(0,100);}


}