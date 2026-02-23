package com.tejait.batch15.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobelException {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDtls> idNotFountException(HttpServletRequest request){
		Date date=new Date();
		ErrorDtls error=new ErrorDtls(date, 407, "ID Not Found", "given Id Not Available", request.getRequestURI());
		System.out.println(error);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MobileAlredyExists.class)
	public ResponseEntity<ErrorDtls> mobileAlredyExists(HttpServletRequest request){	
	ErrorDtls error=new ErrorDtls(new Date(), 409, "mobile alredy exists", "mobile number is alredy exists", request.getRequestURI());   
		return new ResponseEntity<ErrorDtls>(error, HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(MailAlredyExists.class)
	public ResponseEntity<ErrorDtls> mailAlredyExists(HttpServletRequest request){
		ErrorDtls error=new ErrorDtls(new Date(), 410, "mail alredy exists", "Mail Alredy Exists", request.getRequestURI());
		
		return new ResponseEntity<ErrorDtls>(error, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDtls> globelExceptionMethod(HttpServletRequest request){
		
		ErrorDtls error=new ErrorDtls(new Date(), 501, "something went wrong", "unknown error occures ", request.getRequestURI());
		return new ResponseEntity<ErrorDtls>(error, HttpStatus.INTERNAL_SERVER_ERROR) ;
		
		
	}
	
	

}
