package com.tejait.batch15.serviceimpl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tejait.batch15.exceptions.InsuffiecentFundsException;
import com.tejait.batch15.model.Payment;
import com.tejait.batch15.repository.PaymentRepository;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

	PaymentRepository repository;
	
	private static final Logger logger=LogManager.getLogger(PaymentServiceImpl.class); 
	
	@Override
	
	public Payment savePayment(Payment payment) {
		
		logger.debug("Entered into payment service");
		logger.info("Payment Data: {}", payment);
		
		// failed scenario
		if(payment.getAmount()<1) {
			
			logger.info("Transaction Amount:{}",payment.getAmount());
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Failed");
			logger.warn("Payment Status:{}",payment.getPaymentStatus());
			logger.info("Invalid Amount: {}", payment.getAmount());
			throw new InsuffiecentFundsException("Invalid Amount");
		}
		
		// Fraud Alert
		if(payment.getAmount()>100000) {
		
			logger.warn("Fraud Alert :{}, Alert higher amount transaction :{}",payment.getPayerName(),payment.getAmount());

		
		}
		
		try {
			
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Success");
		Payment savedPayment=repository.save(payment);
		return savedPayment;
		}catch(Exception e){
			logger.error("Error while making payment");
			
			throw e;
		}
	}
	
	@Override
	public Payment getbypaymentId(Integer paymentId) {
		
	return	repository.findById(paymentId).orElseThrow(()->{
		logger.error("Payment ID Not Found:{}", paymentId);
		return new IllegalArgumentException("Payment not Found");
	});
	
	}

	@Override
	public Payment getRefundByPymentId(Integer paymentId) {
		Payment payment=repository.findById(paymentId)
				.orElseThrow(()->{
					logger.error("Payment ID NOT FOUND: {}", paymentId);
			
		 return new IllegalArgumentException("Payment Not Found");
			
		});
		
		
		if(!payment.getPaymentStatus().equalsIgnoreCase("Success")) {
			logger.warn("Payment Status:{}", payment);
			logger.error("Payment Not Allowed For Refund:{}", payment);
			
		throw new IllegalArgumentException("Payment Not Allowed For Refund");	
		}
		
		payment.setPaymentStatus("Refund");
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}

}
