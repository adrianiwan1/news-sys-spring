package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Komentarze;
import com.example.newssysspring.repositories.KomentarzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KomendarzeDAO {

    @Autowired
    private KomentarzeRepository repo;

    public List<Komentarze> getCommentsForArticle(Integer id) {
        return repo.findAllByArtykulId(id).stream().filter(it-> !it.getUsuniety()).collect(Collectors.toList());
    }

    public void addCommentToArticle(Komentarze comment) {
        save(comment);
    }

    public Komentarze getOneCommentForArticle(Integer commentId) {
        return  repo.findById(commentId).get();
    }

    public void save(Komentarze comment) {
        repo.save(comment);
    }
}
