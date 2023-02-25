package com.eknox.moneytransfer.dao;

// DEVELOPPER IMPORT
import com.eknox.moneytransfer.entities.Transaction;

//LANGUAGE IMPORT
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.transaction_ID like :queryString")
    public Page<Transaction> searchTransaction(@Param("queryString") String keyword,Pageable pageable);
}
