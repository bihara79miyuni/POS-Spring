package com.pos.Spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.Spring.Service.ItemService;
import com.pos.Spring.Service.StockService;
import com.pos.Spring.Service.TransactionService;
import com.pos.Spring.dto.TransactionReqDto;
import com.pos.Spring.entity.Item;
import com.pos.Spring.entity.Stock;
import com.pos.Spring.entity.Transaction;

@RestController
@CrossOrigin(origins="*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.status(200).body(transactions);
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction>createTransaction(@RequestBody TransactionReqDto transactionReqDto){
        
        Transaction transaction = new Transaction();

        transaction.setTotalAmount(0.0);

        List<Long> itemIds = transactionReqDto.getItemIds();

        List<Item> itemTransactions = new ArrayList<>();

        itemIds.forEach(itemId ->{
            Item item = itemService.getItemById(itemId);
            Stock stock = stockService.getStockById(itemId);

            if(item!=null){
                itemTransactions.add(item);
                transaction.setTotalAmount(transaction.getTotalAmount()+item.getPrice());
                stock.setQuantity(stock.getQuantity()-1);
            }
        });

        transaction.setItems(itemTransactions);

        transactionService.createTransaction(transaction);

        return ResponseEntity.status(200).body(transaction);

    }
}
