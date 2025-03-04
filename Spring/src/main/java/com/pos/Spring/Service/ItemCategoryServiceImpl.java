package com.pos.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.Spring.entity.ItemCategory;
import com.pos.Spring.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllItemCategories(){
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory){
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory getItemCategoryById(Long id){
        return itemCategoryRepository.findById(id).orElse(null);
    }
}
