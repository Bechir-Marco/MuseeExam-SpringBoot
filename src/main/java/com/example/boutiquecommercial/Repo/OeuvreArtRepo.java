package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.OeuvreArt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OeuvreArtRepo extends JpaRepository <OeuvreArt, Long> {
    List<OeuvreArt> findOeuvreArtsByTitreTableau(String titreTableau);
}
