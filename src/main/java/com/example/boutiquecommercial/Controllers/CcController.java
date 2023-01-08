package com.example.boutiquecommercial.Controllers;


import com.example.boutiquecommercial.Entities.*;
import com.example.boutiquecommercial.Serv.ServImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Cc")
public class CcController  {
      private final ServImp s;

      @PostMapping("/ajouterMusee")
      public Musee ajouterMusee(@RequestBody Musee musee) {
            return s.ajouterMusee(musee);
      }
      @PostMapping("/ajouterZoneEtAffecterAMusee")
      public Zone ajouterZoneEtAffecterAMusee(@RequestBody Zone zone,@RequestParam Long idMusee) {
            return s.ajouterZoneEtAffecterAMusee(zone, idMusee);
      }
      @PostMapping("/ajouterOeuvreArtEtAffecterAZone")
      public OeuvreArt ajouterOeuvreArtEtAffecterAZone(@RequestBody OeuvreArt oe, @RequestParam Long idZone){
            return s.ajouterOeuvreArtEtAffecterAZone(oe, idZone);
      }
      @PutMapping("/affecterPersonnelsAzone")
      public void affecterPersonnelsAzone(@RequestParam Long idZone, Long idPersonnel){
            s.affecterPersonnelsAzone(idZone, idPersonnel);
      }
      @GetMapping("/titreTableauParMuseeEtDirection")
      public List <String> titreTableauParMuseeEtDirection(@RequestParam Long idMusee, Direction direction){
            return s.titreTableauParMuseeEtDirection(idMusee, direction);
      }

}
