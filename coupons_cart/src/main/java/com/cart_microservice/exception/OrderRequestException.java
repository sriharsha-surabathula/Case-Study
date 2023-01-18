package com.cart_microservice.exception;

public class OrderRequestException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public OrderRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderRequestException(String message) {
		super(message);
	}

}
