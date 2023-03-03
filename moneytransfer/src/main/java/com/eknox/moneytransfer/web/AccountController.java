package com.eknox.moneytransfer.web;
//DEVELOPPER IMPORT
import com.eknox.moneytransfer.dao.AccountRepository;
import com.eknox.moneytransfer.dao.UserRepository;
import com.eknox.moneytransfer.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v0/accounts")
public class AccountController {
    @Autowired
    private UserRepository    userRepository;
    @Autowired
    private AccountRepository accountRepository;
    // Request body model
    record AccountRequest(
            String  phoneNumber,
            String  password,
            double  balance,
            String  currency,
            Integer userIDRef
            ){}

    //CREATE - DONE
    // After review, an account should not be created by itself without being coupled to
    // to a user, so we lock this functionnality
    /*
    @PostMapping(value = "")
    public void createAccount(@RequestBody AccountRequest request) {
        Account account = new Account();
        account.setUsername(request.username);
        account.setPassword(request.password);
        account.setBalance((request.balance));
        account.setUserIDRef(request.userIDRef);
        accountRepository.save(account);
    }*/
    //

    //READ [ALL] - DONE
    @GetMapping(value = "")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    //


    //READ [SINGLE - INDEPENDANT] - DONE
    @GetMapping(value={"{idAccount}"})
    // ,"/api/v0/users/{userID}/accounts/{idAccount}"
    public Account getSingleAccount(@PathVariable("idAccount") Long idAccount){

        return accountRepository.findById(idAccount).get();

    }

    //UPDATE [SINGLE] - DONE
    @PutMapping(value = "{idAccount}")
    public void updateAccount(@PathVariable("idAccount") Long idAccount,@RequestBody AccountRequest request ) {
        Account account = accountRepository.findById(idAccount).get();
        account.setPhoneNumber(request.phoneNumber);
        account.setPassword(request.password);
        accountRepository.save(account);
    }
    //

    //DELETE - DONE
    @DeleteMapping(value = "{idAccount}")
    public void deleteSingleAccount(@PathVariable("idAccount") Long idAccount ) {
        accountRepository.deleteById(idAccount);

    }
    //

}