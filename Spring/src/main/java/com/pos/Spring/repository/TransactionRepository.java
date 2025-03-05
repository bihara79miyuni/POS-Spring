package com.pos.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.Spring.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    
}
