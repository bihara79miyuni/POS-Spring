package com.pos.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.Spring.Service.StockService;
import com.pos.Spring.entity.Stock;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> stockList = stockService.getAllStocks();

        return ResponseEntity.status(200).body(stockList);
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
        Stock createdStock = stockService.createStock(stock);

        return ResponseEntity.status(201).body(createdStock);
    }
    
}
