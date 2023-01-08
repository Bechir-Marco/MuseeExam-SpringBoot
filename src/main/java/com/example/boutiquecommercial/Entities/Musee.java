package com.example.boutiquecommercial.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Musee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    Long id ;
    @Temporal(TemporalType.DATE)
    Date dateInaug;
    String designation;
    String adresse;

    @OneToMany(mappedBy = "musee")
    List<Zone> zoneList;

}
