package com.example.newssysspring.services;

import com.example.newssysspring.dao.ArtykulyDAO;
import com.example.newssysspring.dao.KomendarzeDAO;
import com.example.newssysspring.dao.UzytkownicyDAO;
import com.example.newssysspring.dto.KomentarzeDTO;
import com.example.newssysspring.entities.Artykuly;
import com.example.newssysspring.entities.Komentarze;
import com.example.newssysspring.entities.Uzytkownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentService {
    @Autowired
    KomendarzeDAO komendarzeDAO;
    @Autowired
    UzytkownicyDAO uzytkownicyDAO;
    @Autowired
    ArtykulyDAO artykulyDAO;

    public void addCommentToArticle(KomentarzeDTO dto){
        Komentarze comment = new Komentarze();
        comment.setTresc(dto.getComment());
        Uzytkownicy user = uzytkownicyDAO.getUserById(Integer.parseInt(dto.getUserId()));
        comment.setUzytkownicyID(user);
        Artykuly article = artykulyDAO.getOneArcitleById(Integer.valueOf(dto.getArticleId()));
        comment.setArtykul(article);
        comment.setData(Instant.now());
        comment.setOcena(5);
        comment.setUsuniety(false);
        komendarzeDAO.addCommentToArticle(comment);
    }

    public void deleteComment(Komentarze comment) {
        comment.setUsuniety(true);
        komendarzeDAO.save(comment);
    }
}
