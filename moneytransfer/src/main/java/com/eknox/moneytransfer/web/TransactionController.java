package com.eknox.moneytransfer.web;
//DEVELOPPER IMPORT
import com.eknox.moneytransfer.dao.AccountRepository;
import com.eknox.moneytransfer.dao.TransactionRepository;
import com.eknox.moneytransfer.entities.Account;
import com.eknox.moneytransfer.entities.Transaction;
import com.eknox.moneytransfer.enums.TypeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v0/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Request body model
    // #TODO: replace TransactionRequest attributes
    record TransactionRequest(
            Long               accountID,
            TypeTransaction    typeTransaction,
            double             montantTransaction,
            String             numOrigine,
            String             numDestinataire
    ){}

    //CREATE - DONE
    @PostMapping(value = "")
    public void createTransaction(@RequestBody TransactionRequest request) {
        Transaction transaction = new Transaction();
        // Transaction payload
        transaction.setNumOrigine(request.numOrigine);
        transaction.setNumDestinataire(request.numDestinataire);
        transaction.setMontantTransaction(request.montantTransaction);
        transaction.setTypeTransaction(request.typeTransaction);
        // Identify accounts concerned by operations


        //1. Find emitter informations
        Optional<Account> emitter = accountRepository.findById(request.accountID);

        // tracking balances
        transaction.setSoldeEmetteurAvant(emitter.get().getBalance());

        // tracking balances

        // emitter balance updating
        emitter.get().debiter(request.montantTransaction); // More resilient
        //emitter.get().setBalance(emitter.get().getBalance() - request.montantTransaction); // Less resilient
        //emitter balancer updating

        // tracking balances
        transaction.setSoldeEmetteurApres(emitter.get().getBalance());
        // tracking balances

        transaction.setEmitter(emitter.get());

        //2. Find receiver using the phone number
        Optional<Account> receiver = accountRepository.searchByPhoneNumber(request.numDestinataire);

        // tracking balances
        transaction.setSoldeRecepteurAvant(receiver.get().getBalance());
        // tracking balances
        receiver.get().crediter(request.montantTransaction); // more resilient
        //receiver.get().setBalance(receiver.get().getBalance() + request.montantTransaction); // less resilient


        // tracking balances
        transaction.setSoldeRecepteurApres(receiver.get().getBalance());
        // tracking balances

        transaction.setReceiver(receiver.get());

        transactionRepository.save(transaction);
    }
    //

    //READ [ALL] - DONE
    @GetMapping(value = "")
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    //


    //READ [SINGLE] - DONE
    @GetMapping(value="{idTransaction}")
    public Transaction getSingleTransaction(@PathVariable("idTransaction") Long idTransaction){
        return transactionRepository.findById(idTransaction).get();
    }

    //UPDATE [SINGLE] - DONE
    @PutMapping(value = "{idTransaction}")
    public void updateTransaction(@PathVariable("idTransaction") Long idTransaction,@RequestBody TransactionRequest request ) {
        Transaction transaction = transactionRepository.findById(idTransaction).get();
        transaction.setMontantTransaction(request.montantTransaction);
        transaction.setNumOrigine(request.numOrigine);
        transaction.setNumDestinataire(request.numDestinataire);
        transactionRepository.save(transaction);
    }
    //

    //DELETE - DONE - Only for testing purposes
    @DeleteMapping(value = "{idTransaction}")
    public void deleteSingleTransaction(@PathVariable("idTransaction") Long idTransaction ) {
        transactionRepository.deleteById(idTransaction);
    }
    //

}