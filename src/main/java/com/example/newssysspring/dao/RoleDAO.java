package com.example.newssysspring.dao;

import com.example.newssysspring.entities.Role;
import com.example.newssysspring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDAO {
    @Autowired
    private RoleRepository repo;

    public Role getRolaById(Integer id) {

        return repo.findById(id).get();

    }
}
