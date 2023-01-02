package com.eknox.moneytransfer.entities;

import lombok.*;

/**
 * Account
 */
@NoArgsConstructor
public class Account {
  
  private final String      numCompte; 
  private final String      nomUtilisateur;  
  private final String      password; 
  private final Date        dateOuverture; 
  private final Double      solde; 

Account(double balance)
{
  this.balance = balance;
}

public double getBalance()
{
  return balance;
}
public int getNumCompte() {
      return numcompte;
  }
public void setNumCompte(int numcompte) {
      this.numcompte = numcompte;
  }
public static void Afficher()
{
Account cpt = new Account(0.0);
System.out.println("le solde est de : " +cpt.getBalance() + "FCFA");
} 
/**
*Methode permettant de debiter le solde d'un compte. Elle est synchronise 
*pour eviter des acces concurrents sur un compte donne.
*@param montant
*/
public synchronized void debiter(int montant)
{
montant = montant >=0 ? montant : -montant;
if(this.balance >= montant)
{
  this.solde -= montant;
}
else
{
  this.decouvert += montant - this.solde;
  this.solde = 0;
}
}
/**
*Methode permettant de crediter le solde d'un compte. Elle est synchronise 
*pour eviter des acces concurrents sur un compte donne.
*@param montant
*/
public synchronized void crediter(int montant)
{
montant = montant >=0 ? montant : -montant;
if(this.decouvert > 0)
{
  if(montant >= this.decouvert)
  {
  montant -= this.decouvert;
  this.decouvert = 0;
  }
else
{
  this.decouvert -= montant;
  return;
}
}
  this.solde += montant;
}
}
