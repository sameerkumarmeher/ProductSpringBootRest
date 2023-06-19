package com.globallogic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> idNotFound(IdNotFoundException exception){
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException exception){
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nameShouldNotBeNull(NullPointerException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> arithmeticException(ArithmeticException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> numberFormatException(NumberFormatException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
