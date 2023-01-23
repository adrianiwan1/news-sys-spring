package com.example.newssysspring.repositories;

import com.example.newssysspring.entities.Uzytkownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Integer> {
    Uzytkownicy findByLogin(String login);
    Optional<Uzytkownicy> findById(Integer id);

}
