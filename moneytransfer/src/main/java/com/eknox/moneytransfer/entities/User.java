package com.eknox.moneytransfer.entities;

import com.eknox.moneytransfer.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder // allows to user the Builder design pattern
@Table(name = "users")
public class User implements Serializable,UserDetails {
    // Cette classe ne sera pas abstraite pour le besoin de développement
    private static final long serialVersionUID = 2460416724595556972L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // use uuid for banking systems
    @Column(name="user_id")
    private Integer   userID;
    private String    nom;
    private String    prenom;
    private Date      dateNaissance;
    private String    lieuNaissance;
    private String    phoneNumber;
    private String    email;
    private String    adresse;
    private String    password;
    // role
    @Enumerated(EnumType.STRING)
    private Role role;
    // Attributes for references
    // @Column(name = "account_id")
    private Long      accountRefID;

    @OneToOne
    @JsonIgnore
    private Account   account;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

 /* public void CreateAccount()
  {
    System.out.println("Renseignez votre nom :" +sc.next());
    System.out.println("Renseignez votre prénom :" +sc.next());
    int birthyear= sc.nextInt();
     do
     {
       System.out.println("Renseignez votre date de naissance": +sc.nextInt()+"/"+sc.nextInt()+"/"+birthyear());
       break;
     }
    while((year-birthyear)>=18);
    System.out.println("Renseignez votre lieu de naissance :" +sc.next());
    System.out.println("Renseignez votre adresse :" +sc.next());
    System.out.println("Renseignez votre email :" +sc.next());
    System.out.println("Renseignez votre numéro de téléphone :" +sc.nextInt());
    System.out.println("Chosissez votre nom d'utilisateur :" +sc.next());
    System.out.println("Choisissez votre mot de passe :" +sc.next());
    System.out.println("Confirmez votre mot de passe :" +sc.next());
    System.out.println("Merci. Votre compte a été créé avec succés");
  }*/
}
