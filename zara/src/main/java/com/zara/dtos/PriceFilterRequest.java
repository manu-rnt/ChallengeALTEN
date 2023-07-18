package com.zara.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PriceFilterRequest {
	@NotNull(message = "El campo applicationDate no puede ser nulo")
    private LocalDateTime applicationDate;
	
	@NotNull(message = "El campo productId no puede ser nulo")
    private Long productId;
	
	@NotNull(message = "El campo brandName no puede ser nulo")
    private String brandName;
}
