package com.pos.Spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pos.Spring.entity.Transaction;

@Service
public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction createTransaction(Transaction transaction);
}
