package com.example.boutiquecommercial.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    @Temporal(TemporalType.DATE)
    Date dateDerniereAffectation;
    @Enumerated(EnumType.STRING)
    TypePersonnel typePersonnel;

    @ManyToOne()
    Zone zone;
    @OneToOne(mappedBy = "personnelSuperviseur")
    Zone zoneSuperviseur;
}
