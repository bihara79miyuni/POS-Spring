package com.pos.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.Spring.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{
    
}
