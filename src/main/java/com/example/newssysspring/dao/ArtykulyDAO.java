package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Artykuly;
import com.example.newssysspring.repositories.ArtykulyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtykulyDAO {

    @Autowired
    private ArtykulyRepository artykulyRepository;

    public List<Artykuly> getNewestArticles(){
        //zamien z find all na jakies by szukalo od daty
        return artykulyRepository.findAll();
    }

}
