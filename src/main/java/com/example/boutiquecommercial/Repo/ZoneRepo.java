package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.Direction;
import com.example.boutiquecommercial.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepo extends JpaRepository<Zone, Long> {
    List<Zone> findZonesByMuseeIdAndDirection(Long id, Direction dire);
    List<Zone> findZonesByActif(boolean a);
}
