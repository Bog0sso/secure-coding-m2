package com.eknox.moneytransfer.dao;

// DEVELOPPER IMPORT
import com.eknox.moneytransfer.entities.User;

//LANGUAGE IMPORT
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends JpaRepository<User, String> {
    @Query("select u from User u where u.phoneNumber like :queryString")
    public Page<User> searchUser(@Param("queryString") String keyword,Pageable pageable);
}
