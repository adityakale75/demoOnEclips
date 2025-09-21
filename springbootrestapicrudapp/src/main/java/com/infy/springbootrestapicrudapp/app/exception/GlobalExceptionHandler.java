package com.infy.springbootrestapicrudapp.app.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ProductNotFoundException.class)	
	public ResponseEntity<ApiError> ProductNotFoundExceptionHandler(ProductNotFoundException e,
			HttpServletRequest request) {
		
		System.out.println("global based exception handler");
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(),new Date(),HttpStatus.NOT_FOUND, request.getRequestURI());
		
		
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
	
}
