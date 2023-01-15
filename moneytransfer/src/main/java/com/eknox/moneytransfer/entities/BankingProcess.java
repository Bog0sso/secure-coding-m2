// Cette classe a pour rôle d'augmenter la performance des opérations bancaires
// Elle a été commenté car n'étant pas encore au point.
/*
package com.eknox.moneytransfer.entities;
class CreditProcess extends Thread
{
	Transaction trans;
	Account compte;
	
	public CreditProcess(Account compte, Transaction trans) 
	{
		this.compte = compte;
		this.trans = trans;
	}
	
	@Override
	public void run() 
	{
		compte.crediter(trans.getMontantTransaction());
		System.out.println("Operation de credit effectuee");
		System.out.println("\nL'operation de credit de "+trans.getMontant()+ " "+trans.getDevise()+" sur le compte "+compte.getNumCompte()" a ete effectue.\n
          Status:  "+trans.getStatus()+"  !
        \n Numero Transaction: "+trans.getId()+"\n
         Date transaction :"+trans.getDateTrans());

	}
}

class DebitProcess extends Thread
{
	Transaction trans;
	Account compte;
	
	public DebitProcess(Account compte, Transaction trans) 
	{
		this.compte = compte;
		this.trans = trans;
	}
	
	@Override
	public void run() 
	{
		Account.debiter(trans.getMontantTransaction());
		System.out.println("Operatio de debit effectuee");
		/*System.out.println("\nL'operation de debit de "+trans.getMontant()+ " "+trans.getDevise()+" sur le compte "+compte.getNumCompte()" a ete effectue.\n
          Status:  "+trans.getStatus()+"  !
        \n Numero Transaction: "+trans.getId()+"\n
         Date transaction :"+trans.getDateTrans());

	}
}*/