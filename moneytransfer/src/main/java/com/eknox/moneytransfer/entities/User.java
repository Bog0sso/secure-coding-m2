package com.eknox.moneytransfer.entities;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User implements Serializable{
    // Cette classe ne sera pas abstraite pour le besoin de développement
    private static final long serialVersionUID = 2460416724595556972L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long      user_ID;
    private String    nom;
    private String    prenom;
    private Date      dateNaissance;
    private String    lieuNaissance;
    private String    numeroTelephone;
    private String    email;
    private String    adresse ;

}
