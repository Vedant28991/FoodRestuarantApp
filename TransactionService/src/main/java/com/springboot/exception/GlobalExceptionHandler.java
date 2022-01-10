package com.springboot.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleException(MethodArgumentNotValidException ex){
		List<FieldError> errors=ex.getFieldErrors();
		ValidationErrorResponse validationErrorResponse=new ValidationErrorResponse();
		validationErrorResponse.setDatetime(LocalDateTime.now());
		validationErrorResponse.setMessage("Input Data has Some Errors !!");
		validationErrorResponse.setStatuscode(HttpStatus.BAD_REQUEST.value());
		
		for(FieldError fieldError:errors) {
			
			
			validationErrorResponse.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
			
			
		}
		
		return new ResponseEntity<ValidationErrorResponse>(validationErrorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ValidationErrorResponse> handleException(ConstraintViolationException ex){
		
		ValidationErrorResponse validationErrorResponse=new ValidationErrorResponse();
		validationErrorResponse.setDatetime(LocalDateTime.now());
		validationErrorResponse.setMessage("Input Data has Some Errors Fix");
		validationErrorResponse.setStatuscode(HttpStatus.BAD_REQUEST.value());
		
		ex.getConstraintViolations().forEach(error->{
			validationErrorResponse.getErrors().put("Feild", error.getMessage());
		});
		
		return new ResponseEntity<ValidationErrorResponse>(validationErrorResponse,HttpStatus.BAD_REQUEST);	
	}
	
	
	
	
}
