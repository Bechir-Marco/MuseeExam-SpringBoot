package com.example.boutiquecommercial.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
     Long id;
    String code ;
    String libelle;
    @Enumerated(EnumType.STRING)
    Direction direction;
    Boolean actif;

    @OneToOne()
    Personnel personnelSuperviseur;

    @OneToMany(mappedBy = "zone")
    List<Personnel> personnelGardiens;

    @ManyToOne()
    Musee musee;

    @OneToMany(mappedBy = "zone")
    List<OeuvreArt> oeuvreArts;
}
