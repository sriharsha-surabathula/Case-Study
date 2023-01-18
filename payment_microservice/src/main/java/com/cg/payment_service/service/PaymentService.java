package com.cg.payment_service.service;

import com.cg.payment_service.entity.PaymentDetails;

public interface PaymentService {

	PaymentDetails doPay(PaymentDetails payment);
	 

}