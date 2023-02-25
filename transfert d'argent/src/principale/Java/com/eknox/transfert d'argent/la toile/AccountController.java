package com.eknox.moneytransfer.web;
//DEVELOPPER IMPORT
import com.eknox.moneytransfer.dao.AccountRepository;
import com.eknox.moneytransfer.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestContr
@RequestMapping(value = "/api/v0/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    // Request body model
    record AccountRequest(
            String username,
            String password,
    ){}

    //CREATE - DONE
    @PostMapping(value = "")
    public void createAccount(@RequestBody AccountRequest request) {
        Account account = new Account();
        account.setUsername(request.username);
        account.setPassword(request.password);
        accountRepository.save(account);
    }
    //

    //READ [ALL] - DONE
    @GetMapping(value = "")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    //


    //READ [SINGLE] - DONE
    @GetMapping(value="{idAccount}")
    public Account getSingleAccount(@PathVariable("idAccount") Integer idAccount){
        return accountRepository.findById(idAccount).get();
    }

    //UPDATE [SINGLE] - DONE
    @PutMapping(value = "{idAccount}")
    public void updateAccount(@PathVariable("idAccount") Integer idAccount,@RequestBody AccountRequest request ) {
        Account account = accountRepository.findById(idAccount).get();
        account.setUsername(request.username);
        account.setPassword(request.password);
        accountRepository.save(account);
    }
    //

    //DELETE - DONE
    @DeleteMapping(value = "{idAccount}")
    public void deleteSingleAccount(@PathVariable("idAccount") Integer idAccount ) {
        accountRepository.deleteById(idAccount);
    }
    //

}