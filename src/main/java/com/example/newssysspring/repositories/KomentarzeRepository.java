package com.example.newssysspring.repositories;

import com.example.newssysspring.entities.Komentarze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomentarzeRepository extends JpaRepository<Komentarze, Integer> {
    @Query("select k from Komentarze k where k.artykul.id = ?1")
    List<Komentarze> findAllByArtykulId(Integer id);

}
