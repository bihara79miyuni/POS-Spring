package com.pos.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.Spring.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    
}
