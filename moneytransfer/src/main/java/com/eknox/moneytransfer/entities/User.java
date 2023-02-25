package com.eknox.moneytransfer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public  class User implements Serializable{
    // Cette classe ne sera pas abstraite pour le besoin de développement
    private static final long serialVersionUID = 2460416724595556972L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer   userID;
    private String    nom;
    private String    prenom;
    private Date      dateNaissance;
    private String    lieuNaissance;
    private String    numeroTelephone;
    private String    email;
    private String    adresse;

    // Attributes for references
    // @Column(name = "account_id")
    private Long      accountRefID;

    @OneToOne
    @JsonIgnore
    private Account   account;

 /* public void CreateAccount()
  {
    System.out.println("Renseignez votre nom :" +sc.next());
    System.out.println("Renseignez votre prénom :" +sc.next());
    int birthyear= sc.nextInt();
     do
     {
       System.out.println("Renseignez votre date de naissance": +sc.nextInt()+"/"+sc.nextInt()+"/"+birthyear());
       break;
     }
    while((year-birthyear)>=18);
    System.out.println("Renseignez votre lieu de naissance :" +sc.next());
    System.out.println("Renseignez votre adresse :" +sc.next());
    System.out.println("Renseignez votre email :" +sc.next());
    System.out.println("Renseignez votre numéro de téléphone :" +sc.nextInt());
    System.out.println("Chosissez votre nom d'utilisateur :" +sc.next());
    System.out.println("Choisissez votre mot de passe :" +sc.next());
    System.out.println("Confirmez votre mot de passe :" +sc.next());
    System.out.println("Merci. Votre compte a été créé avec succés");
  }*/
}
