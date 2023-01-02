package com.eknox.moneytransfer.entities;

import lombok.*;

@Entity 
@NoArgsConstructor
public abstract class User implements Serializable{
@Getter
String private final   utilisateur_ID; 

@Getter @Setter
String private final   nom;

@Getter @Setter
String private final   prenom;

@Getter @Setter
Date   private final   dateNaissance;

@Getter
String private final   lieuNaissance; 

@Getter 
String private final   numeroTelephone; 

@Getter @Setter
String private final   email; 

@Getter @Setter
String private final   adresse ; 
public User(){}

}
