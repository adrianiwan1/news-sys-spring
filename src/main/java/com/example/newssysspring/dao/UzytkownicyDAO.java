package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Uzytkownicy;
import com.example.newssysspring.repositories.UzytkownicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzytkownicyDAO {

    @Autowired
    private UzytkownicyRepository repo;

    public List<Uzytkownicy> getAllUsers(){
        return repo.findAll();
    }

    public void addUser(Uzytkownicy uzytkownik) {
        repo.save(uzytkownik);
    }

    public Uzytkownicy getUserById(int i) {
        return repo.findById(i).get();
    }

    public Uzytkownicy getUserByLogin(String login) {
        return repo.findByLogin(login);
    }
}
