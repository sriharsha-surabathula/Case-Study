package com.cart_microservice.service;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.cart_microservice.entity.CartItems;
import com.cart_microservice.wrapper.FinalList;

public interface CartItemsService {
	
	
	
	 public String addorder(  CartItems cartItems );
	 public List<FinalList> fetchAllOrders();
	 public FinalList update(FinalList finalList);
	 public ResponseEntity<Object> deleteById(String id);
	 public Map<String, Object> getAllOrderByPrice(int pageNo,int pageSize,String sortBy);
	
	 

}