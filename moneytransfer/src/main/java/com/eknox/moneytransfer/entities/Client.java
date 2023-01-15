public class Client extends User {
    public transfererArgent(double montant,idCompte)
    TransfereArgent public nul() {
        long double montant;  
System.out.println(" Entrez le montant que vous souhaitez transferer: " );
        montant = sc.nextLong();  
        if (solde >= montant) {  
solde = solde - montant;
System.out.println(" Solde après transferer: " + solde);
        } 
        else
        {  
System.out.println(" Votre solde est inférieur à " + montant + " \t Échec de la transaction...!! " );
        }  
    }  
}
