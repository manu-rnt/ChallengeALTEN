package com.zara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zara.entities.Prices;

public interface PricesRepository extends JpaRepository<Prices, Long> {    
    
    List<Prices> findByProductIdAndBrandId(Long productId, Long brandId);
}