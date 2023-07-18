package com.zara.service.Impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zara.dtos.PriceFilterRequest;
import com.zara.dtos.PriceFilterResponse;
import com.zara.entities.Brand;
import com.zara.entities.Prices;
import com.zara.exception.BrandNotFoundException;
import com.zara.exception.PriceNotFoundException;
import com.zara.repository.BrandRepository;
import com.zara.repository.PricesRepository;
import com.zara.service.PriceFilterService;

@Service
public class PriceFilterServiceImpl implements PriceFilterService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public PriceFilterResponse filterPrices(PriceFilterRequest request) {
        LocalDateTime applicationDate = request.getApplicationDate();
        Long productId = request.getProductId();
        String brandName = request.getBrandName();
        Brand brand = brandRepository.findByName(brandName);

        if (brand == null) {
            throw new BrandNotFoundException("Marca no encontrada");
        }

        // Obtengo todos los precios que coinciden con el productId y brandId
        List<Prices> matchingPrices = pricesRepository.findByProductIdAndBrandId(productId, brand.getId());

        // Filtro los precios según la fecha y hora
        List<Prices> selectedPrices = matchingPrices.stream()
                .filter(price -> {
                    LocalDateTime startDate = price.getStartDate();
                    return applicationDate.toLocalDate().isEqual(startDate.toLocalDate()) &&
                            applicationDate.toLocalTime().isAfter(startDate.toLocalTime());
                })
                .collect(Collectors.toList());
        
        if (selectedPrices.isEmpty()) {
            throw new PriceNotFoundException("La fecha ingresada o el productId no son válidos");
        }
        
        List<Prices> filteredPrices = selectedPrices.stream()
                .filter(price -> applicationDate.isBefore(price.getEndDate()))
                .collect(Collectors.toList());
        
        Prices maxPriorityPrice = filteredPrices.stream()
                .max(Comparator.comparingInt(Prices::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("No se encontró un precio con la mayor prioridad"));

        // Creo el objeto de respuesta con todos los datos del registro con mayor prioridad
        return new PriceFilterResponse(
                maxPriorityPrice.getProductId(),
                maxPriorityPrice.getBrandId(),
                maxPriorityPrice.getStartDate(),
                maxPriorityPrice.getEndDate(),
                maxPriorityPrice.getPrice()
        );
    }
}