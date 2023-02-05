package com.cts.dailyshareprice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.dailyshareprice.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	public List<Stock> findAll();
	public Stock findByStockName(String stockName);

}
