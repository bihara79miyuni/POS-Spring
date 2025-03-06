package com.pos.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.Spring.Service.ItemCategoryService;
import com.pos.Spring.entity.ItemCategory;

@RestController
@CrossOrigin(origins="*")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/itemCategories")
    public ResponseEntity<List<ItemCategory>> getAllItemCategories(){
        List<ItemCategory> itemCategoryList = itemCategoryService.getAllItemCategories();
        return ResponseEntity.status(200).body(itemCategoryList);
    }

    @PostMapping("/itemCategories")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory){
        ItemCategory createdItemCategory = itemCategoryService.createItemCategory(itemCategory);
        return ResponseEntity.status(201).body(createdItemCategory);
    }

    @GetMapping("/itemCategories/{itemCategoryId}")
    public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable Long id){
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(id);

        if(itemCategory == null){
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(itemCategory);
        }
    }

    
}
