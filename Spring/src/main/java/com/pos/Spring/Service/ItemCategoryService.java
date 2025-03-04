package com.pos.Spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pos.Spring.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllItemCategories();
    ItemCategory createItemCategory(ItemCategory itemCategory);
    ItemCategory getItemCategoryById(Long id);
}
