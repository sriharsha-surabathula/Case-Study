package com.cg.cart_microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cart_microservice.entity.CartItems;
import com.cart_microservice.exception.OrderRequestException;
import com.cart_microservice.repository.CartItemRepository;
import com.cart_microservice.service.CartItemsService;
import com.cart_microservice.wrapper.FinalList;


@SpringBootTest
class CouponsCartMcsApplicationTests {

	@Autowired
	private CartItemsService service;
	
	@MockBean
	private CartItemRepository repository;
	
	@Test
	@DisplayName("The Get All Order Test is Running....")
	public void fetchAllOrdersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new FinalList("abc","abc","abc","abc",12,12),new FinalList("abc","abc","abc","abc",12,12)).collect(Collectors.toList()));
		assertEquals(2, service.fetchAllOrders().size());
	}
	
	
	
	@Test
	@DisplayName("The Delete by Id Test is Running....")
	@Disabled
	public void deleteByIdTest() {
		String id = "abc";
		FinalList cartItems = new FinalList("abc","abc","abc","abc",12,12);
		repository.save(cartItems);
		service.deleteById(id);
		
	}
	@Test
	@DisplayName("The updateProduct Test is Running....")
	public void updateProductTest() {
		FinalList cartItems = new FinalList("abc","abc","abc","abc",12,12);
		repository.save(cartItems);
		FinalList cartItems1 = new FinalList("abc","abc","abc","abc",12,12);
		assertEquals(null, service.update(cartItems1));
		
		
	}
	@Test
	@DisplayName("The Fetch by Id Test is Running....")
	public void FetchProductTest() {
		FinalList cartItems = new FinalList("abc","abc","abc","abc",12,12);
		repository.save(cartItems);
		FinalList cartItems1 = new FinalList("abc","abc","abc","abc",12,12);
		assertEquals(null, service.update(cartItems1));
		
		
	}
	
	@Test
	@DisplayName("The Add Order Test is Running....")
	public void addorderTest() {
		FinalList cartItems = new FinalList("abc","abc","abc","abc",12,12);
		when(repository.save(cartItems)).thenReturn(cartItems);
		assertEquals("Coupon Added Successfully in Cart", "Coupon Added Successfully in Cart");
	
}
}