package com.pos.Spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pos.Spring.entity.Stock;

@Service
public interface StockService {
    List<Stock>getAllStocks();
    Stock createStock(Stock stock);
    Stock getStockById(Long id);
    Stock updateStock(Long id,Stock stock);
    void deleteStock(Long id);
    
}
