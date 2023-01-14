package com.eknox.moneytransfer.entities;

// DEVELOPPER IMPORT
import com.eknox.moneytransfer.enums.TypeTransaction;
// LANGUAGE IMPORT
import java.util.Date;
import enums.*;

public class Transaction {
	//Core information
		@Id
		private Long transaction_ID;
		private String numOrigine;
		private String numDestinataire;
	    private double montantTransaction;
	    private Devise devise;
		private Date dateTransaction;
		private TypeTransaction typeTransaction;
		private StatusTransaction statusTransaction = StatusTransaction.ATTENTE; // Le status par défaut des transactions est "en attente"

	//Tracing information
		private double soldeEmetteurAvant;
		private double soldeEmetteurApres;
		private double soldeRecepteurAvant;
		private double soldeRecepteurApres;

	
public Transaction(String transaction_ID,String numOrigine, String numDestinataire, StatusTransaction statusTransaction, double montantTransaction, Devise devise,TypeTransaction typeTransaction,
				   StatusTransaction statusTransaction) {
			super();
			this.setTrasaction_ID(transaction_ID);
			this.setNumOrigine(numOrigine)
			this.setNumDestinataire(numDestinataire);
			this.setStatusTransaction(statusTransaction);
			this.setMontantTransaction(montantTransaction);
			this.setDevise(devise);
			this.setDateTransaction(System.currentTimeMillis());
		}

		// Les getters et setteurs seront remplacées par des annotations Lombok pour éviter d'avoir un code extensif.


	
}
