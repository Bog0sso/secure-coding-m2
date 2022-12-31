package com.eknox.moneytransfer.entities;

import java.util.Date;

import enums.Devise;
import enums.Status;

public class Paiement  extends Transaction{
	private String modePaiement;

	public Paiement(String id, String numDestinataire, Status status, double montant, Devise devise, Date dateTrans,
			String modePaiement) {
		super(id, numDestinataire, status, montant, devise, dateTrans);
		this.setModePaiement(modePaiement);
	}

	private String getModePaiement() {
		return modePaiement;
	}

	private void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	
	

}
