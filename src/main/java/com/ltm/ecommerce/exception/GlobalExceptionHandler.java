package com.ltm.ecommerce.exception;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmAnyAssociationType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ltm.ecommerce.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleOrderNotFound(OrderNotFoundException ex) {
		return new ErrorResponse(404, ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().
		forEach(error ->errors.put(error.getField(),error.getDefaultMessage()));
		
		return new ErrorResponse(400, "Validation failed",errors);
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleGenericException(Exception ex) {
		return new ErrorResponse(500, "Something went wrong",null);
	}
	
	
}
