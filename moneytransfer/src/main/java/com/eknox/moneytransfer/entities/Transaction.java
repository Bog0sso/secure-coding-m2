package com.eknox.moneytransfer.entities;
import java.util.Date;
import enums.*;
public class Transaction {
		private String id,numDestinataire;
	    private Status status;
	    private double montant;
	    private Devise devise;
	    private Date dateTrans;

	    
	
public Transaction(String id, String numDestinataire, Status status, double montant, Devise devise,
				Date dateTrans) {
			super();
			this.setId(id);;
			this.setNumDestinataire(numDestinataire);
			this.setStatus(status);
			this.setMontant(montant);
			this.setDevise(devise);
			this.setDateTrans(dateTrans);
		}



private String getId() {
	return id;
}



private void setId(String id) {
	this.id = id;
}



private String getNumDestinataire() {
	return numDestinataire;
}



private void setNumDestinataire(String numDestinataire) {
	this.numDestinataire = numDestinataire;
}



private Status getStatus() {
	return status;
}



private void setStatus(Status status) {
	this.status = status;
}



private double getMontant() {
	return montant;
}



private void setMontant(double montant) {
	this.montant = montant;
}



private Devise getDevise() {
	return devise;
}



private void setDevise(Devise devise) {
	this.devise = devise;
}



private Date getDateTrans() {
	return dateTrans;
}



private void setDateTrans(Date dateTrans) {
	this.dateTrans = dateTrans;
}




	
}
