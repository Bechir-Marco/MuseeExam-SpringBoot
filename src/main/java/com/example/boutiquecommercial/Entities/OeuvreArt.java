package com.example.boutiquecommercial.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class OeuvreArt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    Long id ;
    String titreTableau;
    String artiste;

    @ManyToOne()
    Zone zone;
}
