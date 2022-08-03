package com.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler( ResourceNotFoundException ex) {
		String mess = ex.getMessage();
		ApiResponse res = new ApiResponse(mess, false);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.NOT_FOUND);
	}
}
