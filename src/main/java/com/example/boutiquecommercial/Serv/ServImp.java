package com.example.boutiquecommercial.Serv;

import com.example.boutiquecommercial.Entities.*;
import com.example.boutiquecommercial.Repo.MuseeRepo;
import com.example.boutiquecommercial.Repo.OeuvreArtRepo;
import com.example.boutiquecommercial.Repo.PersonnelRepo;
import com.example.boutiquecommercial.Repo.ZoneRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServImp  {

    @Autowired
    ZoneRepo zoneRepo;
    @Autowired
    OeuvreArtRepo oeuvreArtRepo;
    @Autowired
    PersonnelRepo personnelRepo;
    @Autowired
    MuseeRepo museeRepo;


    public Musee ajouterMusee(Musee musee) {
       return museeRepo.save(musee);
    }
    public Zone ajouterZoneEtAffecterAMusee(Zone zone, Long idMusee) {
        Musee musee = museeRepo.findById(idMusee).orElse(null);
        zone.setMusee(musee);
       return zoneRepo.save(zone);
    }
    public OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oe, Long idZone){

        Zone zone = zoneRepo.findById(idZone).orElse(null);
        oe.setZone(zone);
        return  oeuvreArtRepo.save(oe);
    }
    public void affecterPersonnelsAzone(Long idZone, Long idPersonnel) {
        Zone zone = zoneRepo.findById(idZone).orElse(null);
        Personnel personnel = personnelRepo.findById(idPersonnel).orElse(null);
        if (personnel.getTypePersonnel()== TypePersonnel.GARDIEN) {
            personnel.setZone(zone);

        }
        else {
            personnel.setZoneSuperviseur(zone);

        }
        personnelRepo.save(personnel);
    }
    public List <String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction){
    List<Zone> zones = zoneRepo.findZonesByMuseeIdAndDirection(idMusee,direction);
    List <String> strings = new ArrayList<>();
        for (Zone z: zones){
            for (OeuvreArt oe: z.getOeuvreArts()){
                strings.add(oe.getTitreTableau());
            }
        }
        return strings;
    }
    @Scheduled(fixedRate = 2000)
    public void desaffecterDirecteursZoneInactif(){
            for (Zone z: zoneRepo.findZonesByActif(false)){
               z.setPersonnelSuperviseur(null);
                zoneRepo.save(z);
            }
    }
}
