package com.example.newssysspring.controllers;

import com.example.newssysspring.dto.UzytkownicyDTO;
import com.example.newssysspring.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    UserLoginService userLoginService;

    @Autowired
    NewsController newsController;

    @GetMapping("login")
    public String logIn(Model model){
        model.addAttribute("form",new UzytkownicyDTO());
        return "login";
    }
    @PostMapping("login")
    public String logInEffect(Model model, UzytkownicyDTO dto, HttpSession session){

        userLoginService.loginUser(dto,session);
        return newsController.getAllArticles(model, Optional.of(1), Optional.of(5));
    }

    @GetMapping("logout")
    public String logOut(HttpSession session, Model model){
        session.invalidate();
        return newsController.getAllArticles(model, Optional.of(1), Optional.of(5));
    }
}
