package com.stacksimply.restservices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

		//MethodArgumentNotValidException
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
			CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From Method argument Not Valid Exception in GEH", ex.getMessage());
			return new  ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);			
		}
		
		//httpRequestMethodNotSupportedException
		@Override
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
			CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From Method not allowed", ex.getMessage());
			return new  ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);			
		}
		
		
		//UserNameNotFoundException
		@ExceptionHandler(UserNameNotFoundException.class)
		public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex, WebRequest request){
			CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			return new  ResponseEntity<Object>(customErrorDetails,HttpStatus.NOT_FOUND);	
		}
		
		//ConstraintViolationException
		@ExceptionHandler(ConstraintViolationException.class)
		public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
			CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			return new  ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
		}
		
}
