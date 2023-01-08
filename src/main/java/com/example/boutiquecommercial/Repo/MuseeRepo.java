package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.Musee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseeRepo extends JpaRepository <Musee, Long> {

}
