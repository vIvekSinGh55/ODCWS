package com.odcws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.odcws.dto.Responce;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Responce> userNotFoundException(Throwable ex) {
		Responce res = new Responce();
		res.setCode(HttpStatus.NOT_FOUND.value());
		res.setMassage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}

}
