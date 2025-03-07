package com.pos.Spring.controller;

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
import com.pos.Spring.dto.StockReqDto;
import com.pos.Spring.entity.Item;
import com.pos.Spring.entity.Stock;

@RestController
@CrossOrigin(origins="*")
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> stockList = stockService.getAllStocks();

        return ResponseEntity.status(200).body(stockList);
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody StockReqDto stockReqDto){
        Stock stock = new Stock();
        stock.setQuantity(stockReqDto.getQuantity());
        stock.setUpdatedAt(stockReqDto.getUpdatedAt());
        Item item = itemService.getItemById(stockReqDto.getItemId());
        stock.setItem(item);

        Stock createdStock = stockService.createStock(stock);
        return ResponseEntity.status(200).body(createdStock);
    }
    
}
