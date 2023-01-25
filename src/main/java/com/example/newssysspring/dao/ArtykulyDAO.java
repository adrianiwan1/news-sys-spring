package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Artykuly;
import com.example.newssysspring.repositories.ArtykulyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtykulyDAO {

    @Autowired
    private ArtykulyRepository artykulyRepository;

    public List<Artykuly> getNewestArticles() {
        //zamien z find all na jakies by szukalo od daty
        List<Artykuly> allArticles = artykulyRepository.findAll(Sort.by(Sort.Direction.DESC, "dataPublikacji"));
        return allArticles.stream().filter(it -> it.getZbanowany() != 1).collect(Collectors.toList());
    }

    public Artykuly getOneArcitleById(Integer id) {
        return artykulyRepository.findById(id).get();
    }


    public void save(Artykuly artykuly) {
        artykulyRepository.save(artykuly);
    }
}
