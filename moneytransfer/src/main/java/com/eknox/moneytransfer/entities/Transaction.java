package com.eknox.moneytransfer.entities;
import java.util.Scanner;

public class Transaction {
	Scanner sc = new Scanner(System.in);
	private double amount = sc.nextDouble();
	private int numtel = sc.nextInt();
	Account cpt = new Account();
	private double balance = cpt.getBalance();
	public enum TypeTransaction { RETRAIT, TRANSFERT, DEPOT, ACHAT, VENTE }
	
	public void Transat (TypeTransaction typeTransaction) {
		
		switch (typeTransaction) {
		
		case RETRAIT:
			System.out.println("Effectuez un retrait de : " +amount+ "FCFA");
			System.out.println("Saisir le numéro de téléphone du destinataire : " +numtel);
			DeduireMontant(amount, cpt);
			break;
			
		case TRANSFERT:
	         System.out.println("Effectuez un transfert de : " +amount+ "FCFA");
	         System.out.println("Saisir le numéro de téléphone du destinataire : " +numtel);
	         DeduireMontant(amount, cpt);
			break;
			
		case DEPOT:
			 System.out.println("Effectuez un depot de : " +amount+ "FCFA");
			 System.out.println("Saisir le numéro de téléphone du destinataire : " +numtel);
			 AjouterMontant(amount, cpt);
			break;
		case ACHAT:
			 System.out.println("Effectuez un achat de : " +amount+ "FCFA");
			 DeduireMontant(amount, cpt);
			break;
		case VENTE:
			System.out.println("Effectuez une vente de : " +amount+ "FCFA");
			AjouterMontant(amount,cpt);
			break;
		}
	}
	    
	    public void DeduireMontant(double amount, Account cpt)
	    {
	      if(balance>=amount)
	      {
	    	  balance -= amount;
	    	  System.out.println("Le solde est de : " + balance + "FCFA");
	      }
	      else
	      {
	    	  System.out.println("Pas assez d'argent au niveau du compte");
	      }
	      
	    }
	    
		public void AjouterMontant(double amount, Account cpt)
		{
			balance+=amount;
			System.out.println("Le solde est de : " + balance + "FCFA");
		}
}
