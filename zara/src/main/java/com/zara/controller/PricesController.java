package com.zara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zara.entities.Prices;
import com.zara.repository.BrandRepository;
import com.zara.repository.PricesRepository;



@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired
	PricesRepository pricesRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	@GetMapping
    public List<Prices> getAllPrices() {
        return pricesRepository.findAll();
    }
	
	@PostMapping
    public ResponseEntity<?> createPrice(@RequestBody Prices input) {
        Prices save = pricesRepository.save(input);
        return ResponseEntity.ok(save);
    }	
}
