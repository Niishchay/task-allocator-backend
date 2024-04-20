package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> validationExceptionHandler(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((data)->{
			errors.put(data.getField(), data.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> authenticationExceptionHandler(RuntimeException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler
	public ResponseEntity<String> enumExceptionHandler(HttpMessageNotReadableException ex){
		if(ex.getMessage().contains("enum")){
			String enumString = ex.getMessage().substring(ex.getMessage().indexOf("[") + 1, ex.getMessage().indexOf("]"));
			return ResponseEntity.badRequest().body("values accepted: " +enumString);
		}
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
