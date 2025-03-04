package com.pos.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.Spring.Service.ItemService;
import com.pos.Spring.entity.Item;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.getAllItems();
         
        return ResponseEntity.status(200).body(itemList);
    }

    
}
