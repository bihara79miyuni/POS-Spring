package com.pos.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.Spring.entity.Stock;
import com.pos.Spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @Override
    public Stock createStock(Stock stock){
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockById(Long id){
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Stock updateStock(Long id, Stock stock){
        Stock existinStock =  stockRepository.findById(id).orElse(null);

        if(existinStock == null){
            return null;
        }else{
            existinStock.setQuantity(stock.getQuantity());
            existinStock.setUpdatedAt(stock.getUpdatedAt());
            existinStock.setItem(stock.getItem());
            return stockRepository.save(existinStock);
        }
    }

    @Override
    public void deleteStock(Long id){
        stockRepository.deleteById(id);
    }
}
