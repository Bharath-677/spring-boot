package com.tejait.batch15.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tejait.batch15.model.Payment;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("payment")
public class PaymentController {

	PaymentService service;
	
	 private static final Logger logger=LogManager.getLogger(PaymentController.class);
	
	@PostMapping("savepayment")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
		logger.debug("Entered into Payment controller");
		logger.info("Payment Data :{}",payment);
		
		// System.out.println("Entered into Payment controller");
		// System.out.println("Payment Data from user:{}"+payment);
		Payment savedpayment=service.savePayment(payment);	
		logger.info(" Saved Payment Data: {}",savedpayment);
		return new ResponseEntity<>(savedpayment, HttpStatus.OK);	
	}
	
	@GetMapping("bypaymentId/{paymentId}")
	public ResponseEntity<Payment> getBypaymentId(@PathVariable Integer paymentId){
		
		logger.debug("Entired into getPaymentBypaymentId");
		logger.info("paymentId:{}", paymentId);
		Payment getid=service.getbypaymentId(paymentId);
		return new ResponseEntity<>(getid, HttpStatus.OK);
		
	}
	
	@GetMapping("refundByPaymentId/{paymentId}")
	public ResponseEntity<Payment> getRefundPaymentId(@PathVariable Integer paymentId){
		logger.debug("Entered into getRefundByPaymentId");
		logger.info("paymentId:{}", paymentId);
		Payment payment=service.getRefundByPymentId(paymentId);
		return new ResponseEntity<>(payment,HttpStatus.OK) ;
		
		
	}
	
	
	
	
	
	
	
}
