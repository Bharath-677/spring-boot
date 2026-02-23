package com.tejait.batch15.service;

import com.tejait.batch15.model.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);

	Payment getbypaymentId(Integer paymentId);

	Payment getRefundByPymentId(Integer paymentId);

}
