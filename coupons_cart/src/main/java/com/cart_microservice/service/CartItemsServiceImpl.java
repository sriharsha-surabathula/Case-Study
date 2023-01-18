package com.cart_microservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cart_microservice.entity.CartItems;
import com.cart_microservice.exception.OrderRequestException;
import com.cart_microservice.repository.CartItemRepository;
import com.cart_microservice.wrapper.Coupons;
import com.cart_microservice.wrapper.FinalList;


@Service
public class CartItemsServiceImpl implements CartItemsService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	 @Autowired
	 private RestTemplate restTemplate;

	 @Autowired
	 WebClient.Builder webClientBuilder;
	
	
	
	
	
	public String addorder(CartItems cartItems ){
    	Coupons coupon = restTemplate.getForObject("http://localhost:8083/catalogue/find/id/" + cartItems.getCouponId(), Coupons.class);
		FinalList finalList = new FinalList(cartItems.getOrderId(),cartItems.getCouponId(),coupon.getCoupons_name(),coupon.getCoupons_desc(),
				coupon.getCoupons_price(),cartItems.getCoupons_qty());
		cartItemRepository.insert( finalList );
		return ("Coupon Added Successfully in Cart");	
			
	}
	
	
	
	
	
    public List<FinalList> fetchAllOrders() {
    	
    	return  cartItemRepository.findAll();

    }

    
    
    
	public FinalList update(FinalList finalList) {
		
		Optional<FinalList> optionalFinalList = Optional.ofNullable(cartItemRepository.findByorderId(finalList.getOrderId()));
		if(optionalFinalList.isPresent()){
			return  cartItemRepository.save(finalList);
		}else{
			return null;
		}
	}

	
	
	
	public ResponseEntity<Object> deleteById(String id)
	{
		boolean isUserExist=cartItemRepository.existsById(id);
		 if(isUserExist) {
			 cartItemRepository.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new OrderRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
	}


	
	
	
	@Override
	public Map<String, Object> getAllOrderByPrice(int pageNo,int pageSize,String sortBy) {
		// TODO Auto-generated method stub
		Map<String,Object> response = new HashMap<String,Object>();
		Sort sort = Sort.by(sortBy);
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		Page <FinalList> cartItemsPage = cartItemRepository.findAll(page);
		response.put("data", cartItemsPage.getContent());
		return response;
	}
		
}
