package com.example.newssysspring.repositories;

import com.example.newssysspring.entities.Artykuly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtykulyRepository extends JpaRepository<Artykuly, Integer> {

}
