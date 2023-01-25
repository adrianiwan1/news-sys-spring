package com.example.newssysspring.services;

import com.example.newssysspring.dao.ArtykulyDAO;
import com.example.newssysspring.entities.Artykuly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleDeleteService {
    @Autowired
    private ArtykulyDAO artykulyDAO;

    public void deleteArticle(Artykuly artykuly){
        artykuly.setZbanowany(1);
        artykulyDAO.save(artykuly);
    }
}
