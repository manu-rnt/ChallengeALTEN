package com.zara.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PriceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PriceNotFoundException(String message) {
        super(message);
    }
}