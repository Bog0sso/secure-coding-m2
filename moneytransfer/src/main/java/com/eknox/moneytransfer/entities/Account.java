package com.eknox.moneytransfer.entities;

/**
 * Account
 */
 
public class Account() 
{
 private double balance;
 private int numcompte;
 Account(){}
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
}
