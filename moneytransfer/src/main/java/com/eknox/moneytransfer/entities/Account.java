package com.eknox.moneytransfer.entities;
// LANGUAGE IMPORT
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Collection;
import java.util.Date;
// DEVELOPPER IMPORT
import java.util.Currency;

/**
 * Account
 * Les numéro de comptes doivent être auto-généré sans possibilité de les modifier
 * Le solde maximal d'un compte est de 200_000 par défaut et de 2_000_000 si le KYC a été effecté
 * la date d'ouverture est auto-générée
 * Les découverts ne sont pas autorisée, nous sommmes dans un système de mobile money - pas un système bancaire
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table( name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long        numCompte;
  private String      username;
  private String      password;
  private Date        dateOuverture = new Date();
  private Double      balance = 0.0;
  //  private static  Device defaultDevise = Devise.XOF.name();
  Currency currency = Currency.getInstance("XOF");
  // CONSTRAINTS
  //1 . BCEAO : max balance is 2_000_000
  private final Double      SOLDEMAX= 2_000_000.0;

  // Attribute for reference to the user
  private Integer userRefID;
  @OneToOne
  @JsonIgnore
  private User user;

  // Transaction information
  @OneToMany
  private Collection<Transaction>  transactions;

  Account(String username, String password){
  this.username = username;
  this.password = password;

}

public void afficher()
{
  // Cette méthode peut être intéressante dans le cas d'usage avec une CLI
  System.out.println("le solde est de : " + this.getBalance() + "XOF");

}
/**
*Methode permettant de débiter un compte. Elle est synchronisée
*pour éviter des accès concurrents sur un compte.
*@param montant
*/
public synchronized void debiter(double montant)
{
montant = montant >=0 ? montant : -montant;
if(this.balance >= montant)
{
  this.balance -= montant;
}

}
/**
*Methode permettant de crediter le solde d'un compte. Elle est synchronise 
*pour eviter des accès concurrents sur un compte donne.
*@param montant
*/
public synchronized void crediter(double montant)
{
  // On doit créditer les comptes en tenant compte de la variable
montant = montant >= 0 ? montant : -montant;
if(this.balance + montant <= SOLDEMAX)
  this.balance += montant;
}
/*
* - notifierTransaction():void
- voirSolde() : int
- crediter() : double
- debiter(): double
- voirHistorique()
* */
}
