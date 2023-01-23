package com.example.newssysspring.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name = "uzytkownicy")
public class Uzytkownicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dataUrodzenia", length = 10)
    private String dataUrodzenia;

    @Column(name = "plec", length = 1)
    private String plec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wojewodzstwo")
    private Wojewodzstwa wojewodzstwo;

    @Column(name = "powiat", length = 25)
    private String powiat;

    @Column(name = "miejscowosc")
    private String miejscowosc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rola")
    private Role rola;

    @Column(name = "zbanowany")
    private Boolean zbanowany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() >= 32) {
            this.password = password;
        } else {
            this.password = new BCryptPasswordEncoder().encode(password);
        }
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Wojewodzstwa getWojewodzstwo() {
        return wojewodzstwo;
    }

    public void setWojewodzstwo(Wojewodzstwa wojewodzstwo) {
        this.wojewodzstwo = wojewodzstwo;
    }

    public String getPowiat() {
        return powiat;
    }

    public void setPowiat(String powiat) {
        this.powiat = powiat;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public Role getRola() {
        return rola;
    }

    public void setRola(Role rola) {
        this.rola = rola;
    }

    public Boolean getZbanowany() {
        return zbanowany;
    }

    public void setZbanowany(Boolean zbanowany) {
        this.zbanowany = zbanowany;
    }

}