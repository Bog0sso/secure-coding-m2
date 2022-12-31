package com.eknox.moneytransfer.entities;
import java.util.Scanner;

public class Transaction {
	Scanner sc = new Scanner(System.in);
	private double montant = sc.nextDouble();
	private int numtel = sc.nextInt();
	Compte cpt = new Compte();
	private double solde = cpt.getSolde();
	public enum TypeTransaction { RETRAIT, TRANSFERT, DEPOT, ACHAT, VENTE }
	
	public void Transat (TypeTransaction typeTransaction) {
		
		switch (typeTransaction) {
		
		case RETRAIT:
			System.out.println("Effectuez un retrait de : " +montant+ "FCFA");
			System.out.println("Saisir le numéro de téléphone du destinataire : " +numtel);
			DeduireMontant(montant, cpt);
			break;
			
		case TRANSFERT:
	         System.out.println("Effectuez un transfert de : " +montant+ "FCFA");
	         System.out.println("Saisir le numéro de téléphone du destinataire : " +numtel);
	         DeduireMontant(montant, cpt);
			break;
			
		case DEPOT:
			 System.out.println("Effectuez un depot de : " +montant+ "FCFA");
			 System.out.println("Saisir le numéro de téléphone du destinataire : " +numtel);
			 AjouterMontant(montant, cpt);
			break;
		case ACHAT:
			 System.out.println("Effectuez un achat de : " +montant+ "FCFA");
			 DeduireMontant(montant, cpt);
			break;
		case VENTE:
			System.out.println("Effectuez une vente de : " +montant+ "FCFA");
			AjouterMontant(montant,cpt);
			break;
		}
	}
	    
	    public void DeduireMontant(double montant, Compte cpt)
	    {
	      if(solde>=montant)
	      {
	    	  solde -= montant;
	    	  System.out.println("Le solde est de : " + solde + "FCFA");
	      }
	      else
	      {
	    	  System.out.println("Pas assez d'argent au niveau du compte");
	      }
	      
	    }
	    
		public void AjouterMontant(double montant, Compte cpt)
		{
			solde+=montant;
			System.out.println("Le solde est de : " + solde + "FCFA");
		}
}
