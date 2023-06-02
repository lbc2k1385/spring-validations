package com.example.demo.demo.validator;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MailPackageValidator {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
		List<String> errors = ex.getBindingResult().getAllErrors()
				.stream()
		        .map(error -> error.getDefaultMessage())
		        .collect(Collectors.toList());

		return ResponseEntity.badRequest().body(errors);
    }

}
