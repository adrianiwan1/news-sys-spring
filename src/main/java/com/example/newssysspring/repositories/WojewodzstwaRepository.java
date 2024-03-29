package com.example.newssysspring.repositories;

import com.example.newssysspring.entities.Wojewodzstwa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WojewodzstwaRepository extends JpaRepository<Wojewodzstwa, Integer> {

}
