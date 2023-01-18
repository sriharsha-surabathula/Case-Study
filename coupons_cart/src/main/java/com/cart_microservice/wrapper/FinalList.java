package com.cart_microservice.wrapper;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;





@Document(collection ="CartItems")
public class FinalList {

	@Id
	private String orderId;
	private String couponId;
	private String coupons_name;
	private String coupons_desc;
	private int coupons_price;
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


	public String getCoupons_name() {
		return coupons_name;
	}



	public void setCoupons_name(String coupons_name) {
		this.coupons_name = coupons_name;
	}


	public String getCoupons_desc() {
		return coupons_desc;
	}


	public void setCoupons_desc(String coupons_desc) {
		this.coupons_desc = coupons_desc;
	}



	public int getCoupons_price() {
		return coupons_price;
	}



	public void setCoupons_price(int coupons_price) {
		this.coupons_price = coupons_price;
	}


	public int getCoupons_qty() {
		return coupons_qty;
	}

	public void setCoupons_qty(int coupons_qty) {
		this.coupons_qty = coupons_qty;
	}
	


	public FinalList(String orderId, String couponId, String coupons_name, String coupons_desc, int coupons_price,
			int coupons_qty) {
		super();
		this.orderId = orderId;
		this.couponId = couponId;
		this.coupons_name = coupons_name;
		this.coupons_desc = coupons_desc;
		this.coupons_price = coupons_price;
		this.coupons_qty = coupons_qty;
	}

	public FinalList() {
	}

	

	
}