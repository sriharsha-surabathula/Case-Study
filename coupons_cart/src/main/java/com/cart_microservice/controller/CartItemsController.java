package com.cart_microservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart_microservice.entity.CartItems;
import com.cart_microservice.service.CartItemsService;
import com.cart_microservice.wrapper.FinalList;


@RestController
@RequestMapping("/cartItems")
public class CartItemsController {
	
	
	@Autowired
	private CartItemsService cartItemsService;

	
	@PostMapping("/addorder")
	public String addNeworder( @RequestBody CartItems cartItems ){
			return cartItemsService.addorder( cartItems );		
	}

	@GetMapping("/allOrders")
	public List<FinalList> fetchAllProducts(){
		return  cartItemsService.fetchAllOrders();
	}


	@PutMapping("/updateProduct")
	public FinalList updateProduct(@RequestBody  FinalList finalList) {

		return  cartItemsService.update(finalList);
	}

	@DeleteMapping("/deleteProduct/{id}")
	 public String deleteProductById(@PathVariable("id") String id)
	 {
		cartItemsService.deleteById(id);
		return "id no "+id+" is deleted";
	 }
	
	@GetMapping("/allOrders/ByPrice")
	public Map<String, Object> getAllOrderByPrice(@RequestParam(name = "sortby", defaultValue ="coupons_price")String sortBy,
			@RequestParam(name = "pageno", defaultValue = "0") int pageNo,@RequestParam(name = "pagesize", defaultValue = "4") int pageSize){
		return  cartItemsService.getAllOrderByPrice(pageNo,pageSize,sortBy);
	}
}
	
	
