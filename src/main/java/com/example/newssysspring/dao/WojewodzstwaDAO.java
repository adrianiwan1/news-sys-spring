package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Wojewodzstwa;
import com.example.newssysspring.repositories.WojewodzstwaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WojewodzstwaDAO {
    @Autowired
    private WojewodzstwaRepository repo;

    public List<Wojewodzstwa> getAllWojewodztwa(){
        return repo.findAll();
    }
}
