package com.example.newssysspring.services;

import com.example.newssysspring.dao.UzytkownicyDAO;
import com.example.newssysspring.entities.Uzytkownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDisplayService {

    @Autowired
    UzytkownicyDAO uzytkownicyDAO;

    public List<Uzytkownicy> getUsers()
    {
        return uzytkownicyDAO.getAllUsers();
    }
}
