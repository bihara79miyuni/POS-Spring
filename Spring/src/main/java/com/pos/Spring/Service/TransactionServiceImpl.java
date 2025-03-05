package com.pos.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.Spring.entity.Transaction;
import com.pos.Spring.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    @Override
    public Transaction createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
