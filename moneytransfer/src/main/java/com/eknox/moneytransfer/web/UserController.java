package com.eknox.moneytransfer.web;
//DEVELOPPER IMPORT
import com.eknox.moneytransfer.dao.AccountRepository;
import com.eknox.moneytransfer.dao.UserRepository;
import com.eknox.moneytransfer.entities.Account;
import com.eknox.moneytransfer.entities.User;
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
@RequestMapping(value = "/api/v0/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    // Request body model
    record UserRequest(
            Integer   user_ID,
            String    nom,
            String    prenom,
            Date      dateNaissance,
            String    lieuNaissance,
            String    numeroTelephone,
            String    email,
            String    adresse,
            Long      accountID
    ){}

    //CREATE - DONE
    @PostMapping(value = "")
    public void createUser(@RequestBody UserRequest request) {
        /**
         * This code probably contains technical debt with multiple database access
         * The debt should be measured in term of performance
         * Multiple unefficient database access.
         * The debt is tied to the matter of object ownership with simple id-references
         */
        /
        User user = new User();
        Account account = new Account();

        // users informations are saved first
        user.setNom(request.nom);
        user.setPrenom(request.prenom);
        user.setDateNaissance(request.dateNaissance);
        user.setLieuNaissance(request.lieuNaissance);
        user.setNumeroTelephone(request.numeroTelephone);
        user.setEmail(request.email);
        user.setAdresse(request.adresse);
        //account is assigned to user
        user.setAccount(account);
        // account information are saved
        accountRepository.save(account);
        // reference from user to account is made - so the ownership is set
        user.setAccountRefID(account.getNumCompte()); //
        // user ownership saved
        userRepository.save(user);

        // reference from account to user is set
        account.setUserRefID(user.getUserID());
        // reference from account to user is set : we have two ways referencing
        accountRepository.save(account);

    }
    //

    //READ [ALL] - DONE
    @GetMapping(value = "")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    //


    //READ [SINGLE] - DONE
    @GetMapping(value="{idUser}")
    public User getSingleUser(@PathVariable("idUser") Integer idUser){
        return userRepository.findById(idUser).get();
    }

    //UPDATE [SINGLE] - DONE
    @PutMapping(value = "{idUser}")
    public void updateUser(@PathVariable("idUser") Integer idUser,@RequestBody UserRequest request ) {
        User user = userRepository.findById(idUser).get();
        user.setNom(request.nom);
        user.setPrenom(request.prenom);
        user.setDateNaissance(request.dateNaissance);
        user.setLieuNaissance(request.lieuNaissance);
        user.setNumeroTelephone(request.numeroTelephone);
        user.setEmail(request.email);
        user.setAdresse(request.adresse);
        // user.setAccountID(request.accountID);

        userRepository.save(user);
    }
    //

    //DELETE - DONE
    @DeleteMapping(value = "{idUser}")
    public void deleteSingleUser(@PathVariable("idUser") Integer idUser ) {
        userRepository.deleteById(idUser);
    }
    //


    /*
    * NESTED ROUTES FOR ACCOUNTS
    * */

    // READ [SINGLE - NESTED] - DONE
    @GetMapping(value="{idUser}/accounts/{idAccount}")
    public Account getSingleAccount(@PathVariable("idUser") Integer userID , @PathVariable("idAccount") Long idAccount){
        return userRepository.findById(userID).get().getAccount();
        //return accountRepository.findById(idAccount).get().;
    }
}