package com.javapoint.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = UserorPasswordmismatch.class)
	   public ResponseEntity<Object> exception(UserorPasswordmismatch exception) {
	      return new ResponseEntity<>("User id or password mismatch", HttpStatus.UNAUTHORIZED);
	   }

}
