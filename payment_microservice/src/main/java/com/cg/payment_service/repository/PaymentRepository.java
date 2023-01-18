package com.cg.payment_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.payment_service.entity.PaymentDetails;

public interface PaymentRepository extends MongoRepository<PaymentDetails, Integer> {

}
