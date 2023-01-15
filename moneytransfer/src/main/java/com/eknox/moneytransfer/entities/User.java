package com.eknox.moneytransfer.entities;

import lombok.*;
import java.util.Scanner;
import java.util.Date;

Date dt=new Date();
int year= dt.getYear();
Scanner sc= new Scanner(System.in);



@Entity 
@NoArgsConstructor
public abstract class User implements Serializable{
@Getter
String private final   user_ID;

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
  
  public void CreateAccount()
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
  }
  }

}
