package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Komentarze;
import com.example.newssysspring.repositories.KomentarzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomendarzeDAO {

    @Autowired
    private KomentarzeRepository repo;

    public List<Komentarze> getCommentsForArticle(Integer id) {
        return repo.findAllByArtykulId(id);
    }
}
