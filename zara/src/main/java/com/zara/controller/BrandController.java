package com.zara.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zara.entities.Brand;
import com.zara.repository.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    
    @Autowired
    BrandRepository brandRepository;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
