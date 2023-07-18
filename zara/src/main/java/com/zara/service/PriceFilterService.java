package com.zara.service;

import com.zara.dtos.PriceFilterRequest;
import com.zara.dtos.PriceFilterResponse;


public interface PriceFilterService {
    PriceFilterResponse filterPrices(PriceFilterRequest request);
}
