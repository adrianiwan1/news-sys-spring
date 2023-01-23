package com.example.newssysspring.services;

import com.example.newssysspring.dao.KomendarzeDAO;
import com.example.newssysspring.entities.Komentarze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDisplayService {
    @Autowired
    KomendarzeDAO dao;

    public List<Komentarze> getCommentsForArticle(Integer articleId) {
        return dao.getCommentsForArticle(articleId);
    }
}
