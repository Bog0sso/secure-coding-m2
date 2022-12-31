package com.eknox.moneytransfer.entities;

/**
 * Account
 */
 
public class Account() 
{
 private double amount;
 private int numcompte;
 Account(){}
 Account(double amount)
 {
   this.amount = amount;
 }
 
 public double getAmount()
 {
   return amout;
 }
 public static void Afficher()
 {
  Account cpt = new Account(0.0);
  System.out.println("le solde est de : " +cpt.getAmount() + "FCFA");
 } 
}
