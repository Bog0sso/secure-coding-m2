package com.eknox.moneytransfer.web;
//DEVELOPPER IMPORT
import com.eknox.moneytransfer.dao.UserRepository;
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
    // Request body model
    record UserRequest(
            Integer   user_ID,
            String    nom,
            String    prenom,
            Date      dateNaissance,
            String    lieuNaissance,
            String    numeroTelephone,
            String    email,
            String    adresse
    ){}

    //CREATE - DONE
    @PostMapping(value = "")
    public void createUser(@RequestBody UserRequest request) {
        User user = new User();
        user.setNom(request.nom);
        user.setPrenom(request.prenom);
        user.setDateNaissance(request.dateNaissance);
        user.setLieuNaissance(request.lieuNaissance);
        user.setNumeroTelephone(request.numeroTelephone);
        user.setEmail(request.email);
        user.setAdresse(request.adresse);
        userRepository.save(user);
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
        userRepository.save(user);
    }
    //

    //DELETE - DONE
    @DeleteMapping(value = "{idUser}")
    public void deleteSingleUser(@PathVariable("idUser") Integer idUser ) {
        userRepository.deleteById(idUser);
    }
    //

}