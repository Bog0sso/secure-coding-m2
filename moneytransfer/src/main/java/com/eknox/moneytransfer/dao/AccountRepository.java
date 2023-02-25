package com.eknox.moneytransfer.dao;

// DEVELOPPER IMPORT

import com.eknox.moneytransfer.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //@Query("select u from User u where u.numeroTelephone like :queryString")
    //public Page<User> searchUser(@Param("queryString") String keyword,Pageable pageable);
}
