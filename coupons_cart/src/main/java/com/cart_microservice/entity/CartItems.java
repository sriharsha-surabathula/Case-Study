package com.cart_microservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;






public class CartItems {

	@Id
	private String orderId;
	private String couponId;
	private int coupons_qty;
	
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCouponId() {
		return couponId;
	}
	
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public int getCoupons_qty() {
		return coupons_qty;
	}


	public void setCoupons_qty(int coupons_qty) {
		this.coupons_qty = coupons_qty;
	}
	
	
	



	public CartItems(String orderId, String couponId, int coupons_qty) {
		super();
		this.orderId = orderId;
		this.couponId = couponId;
		this.coupons_qty = coupons_qty;
	}

	public CartItems() {
	}

	
	

	
}
