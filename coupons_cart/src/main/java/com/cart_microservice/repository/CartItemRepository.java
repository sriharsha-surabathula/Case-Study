package com.cart_microservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cart_microservice.entity.CartItems;
import com.cart_microservice.wrapper.FinalList;


@Repository
public interface CartItemRepository extends MongoRepository<FinalList, String> {
	
	FinalList findByorderId(String orderId);
	
	

	

}