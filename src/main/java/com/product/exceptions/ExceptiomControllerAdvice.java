package com.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptiomControllerAdvice {
	@ExceptionHandler(value = CustomException.class)
	public final ResponseEntity<String> handlerCustomException(CustomException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = AuthenticationFailException.class)
	public final ResponseEntity<String> handleAuthenticationFailException(AuthenticationFailException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=ProductNotExistException.class)
	public final ResponseEntity<String> handleProductNotExistsException(ProductNotExistException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
