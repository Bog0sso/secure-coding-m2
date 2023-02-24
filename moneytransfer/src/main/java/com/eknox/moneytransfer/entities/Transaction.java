package com.eknox.moneytransfer.entities;

// DEVELOPPER IMPORT
import com.eknox.moneytransfer.enums.TypeTransaction;
import com.eknox.moneytransfer.enums.StatusTransaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// LANGUAGE IMPORT
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
		//Core transaction  informations
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long 				transaction_ID;
		private String 				numOrigine;
		private String 				numDestinataire;
	    private double 				montantTransaction;
		private Date 				dateTransaction;
		private TypeTransaction 	typeTransaction;
		// Default valuee
		/*
		*	Transactions have default state of ----------- ON PROCESS -----------
		* */
		private StatusTransaction statusTransaction = StatusTransaction.ATTENTE; // Le status par défaut des transactions est "en attente"

		//Tracing information
		private double soldeEmetteurAvant;
		private double soldeEmetteurApres;
		private double soldeRecepteurAvant;
		private double soldeRecepteurApres;

		// The emitter is considered to be the one part which account balancer will decrease after the transaction
		@OneToOne
		private Account emitter;

		// The receiver is considered to be the one part which account balance will increase after the transaction
		@OneToOne
		private Account receiver;
/*public Transaction(String transaction_ID,String numOrigine, String numDestinataire, StatusTransaction statusTransaction, double montantTransaction, Devise devise,TypeTransaction typeTransaction,
				   StatusTransaction statusTransaction) {
			super();
			this.setTrasaction_ID(transaction_ID);
			this.setNumOrigine(numOrigine);
			this.setNumDestinataire(numDestinataire);
			this.setStatusTransaction(statusTransaction);
			this.setMontantTransaction(montantTransaction);
			this.setDevise(devise);
			this.setDateTransaction(System.currentTimeMillis());
		}*/

		// Les getters et setteurs seront remplacées par des annotations Lombok pour éviter d'avoir un code extensif.


	
}
