package com.eknox.moneytransfer.entities;

import lombok.*;

/*
- compte_ID : String
- nomUtilisateur : String
- password: String
- dateOuverture: Date
- solde: Double
*/

/**
 * Account
 * Les numéro de comptes doivent être auto-généré sans possibilité de les modifier
 * Le solde maximal d'un compte est de 200_000 par défaut et de 2_000_000 si le KYC a été effecté
 * la date d'ouverture est auto-générée
 * Les découverts ne sont pas autorisée, nous sommmes dans un système de mobile money - pas un système bancaire
 */
@NoArgsConstructor
public class Account {
  
  private final String      numCompte;
  private final String      username;
  private final String      password; 
  private final Date        dateOuverture; 
  private final Double      balance = 0;
  private final Devise      defaultDevise = Devise.XOF
  // CONSTRAINTS
  //1 . BCEAO : max balance is 2_000_000
  private final Double      SOLDEMAX= 2_000_000;

Account(String username, String password){
  this.username = username;
  this.password = password;

}

public static void Afficher()
{ // Cette méthode peut être intéressante dans le cas d'usage avec une CLI
  Account cpt = new Account(0.0);

  System.out.println("le solde est de : " + this.getBalance() + "XOF");

}
/**
*Methode permettant de débiter un compte. Elle est synchronisée
*pour éviter des accès concurrents sur un compte.
*@param montant
*/
public synchronized void debiter(int montant)
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
public synchronized void crediter(int montant)
{
  // On doit créditer les comptes en tenant compte de la variable
montant = montant >= 0 ? montant : -montant;
if(this.solde + montant <= SOLDEMAX)
  this.solde += montant;
}
/*
* - notifierTransaction():void
- voirSolde() : int
- crediter() : double
- debiter(): double
- voirHistorique()
* */
}
