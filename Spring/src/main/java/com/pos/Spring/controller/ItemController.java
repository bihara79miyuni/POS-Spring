package com.pos.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pos.Spring.Service.ItemCategoryService;
import com.pos.Spring.Service.ItemService;
import com.pos.Spring.dto.ItemReqDto;
import com.pos.Spring.entity.Item;
import com.pos.Spring.entity.ItemCategory;

@RestController
@CrossOrigin(origins="*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.getAllItems();
         
        return ResponseEntity.status(200).body(itemList);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemReqDto itemReqDto){
        Item item = new Item(); 
        item.setName(itemReqDto.getName());
        item.setDescription(itemReqDto.getDescription());
        item.setPrice(itemReqDto.getPrice());
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemReqDto.getItemCategoryId());
        item.setItemCategory(itemCategory);

        Item createdItem = itemService.createItem(item);
        return ResponseEntity.status(200).body(createdItem);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Long itemId){
        Item item = itemService.getItemById(itemId);
        if(item == null){
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(item);
        }
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemReqDto itemReqDto,@PathVariable Long itemId){
        Item item = new Item();
        item.setDescription(itemReqDto.getDescription());
        item.setName(itemReqDto.getName());
        item.setPrice(itemReqDto.getPrice());
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemReqDto.getItemCategoryId());
        item.setItemCategory(itemCategory);

        try{
            itemService.updateItem(itemId,item);
            
        }catch(Exception error){
            System.out.println("error");
        }

        return ResponseEntity.status(200).body(item);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
        return ResponseEntity.status(200).body("Deleted Item");
    }
}
