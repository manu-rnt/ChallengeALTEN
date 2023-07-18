package com.zara.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zara.dtos.PriceFilterRequest;
import com.zara.dtos.PriceFilterResponse;

import com.zara.service.PriceFilterService;

@RestController
@RequestMapping("/filter")
public class FilterController {
	@Autowired
    private PriceFilterService priceFilterService;

    @PostMapping
    public ResponseEntity<PriceFilterResponse> filterPrices(@Valid @RequestBody PriceFilterRequest request) {
        PriceFilterResponse response = priceFilterService.filterPrices(request);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }
}
