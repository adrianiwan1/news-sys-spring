package com.example.newssysspring.services;

import com.example.newssysspring.dao.UzytkownicyDAO;
import com.example.newssysspring.dto.UzytkownicyDTO;
import com.example.newssysspring.entities.Uzytkownicy;
import com.example.newssysspring.exceptions.UserDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserLoginService {
    @Autowired
    UzytkownicyDAO uzytkownicyDAO;

    public boolean loginUser(UzytkownicyDTO dto, HttpSession session){
        Uzytkownicy user;

        try{
            user = uzytkownicyDAO.getUserByLogin(dto.getLogin());
        } catch (Exception e){
            throw new UserDoesNotExistsException("Użytkownik " + dto.getLogin() + " nie istnieje");
        }
        if(!new BCryptPasswordEncoder().matches(dto.getPassword(),user.getPassword())){
            return false;
        }
        session.setAttribute("rola",user.getRola());
        session.setAttribute("userId",user.getId());
        session.setAttribute("Login",user.getLogin());

        return true;
    }
}
