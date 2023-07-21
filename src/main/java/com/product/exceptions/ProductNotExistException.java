package com.product.exceptions;

public class ProductNotExistException extends IllegalArgumentException {
	public ProductNotExistException(String msg) {
		super(msg);
		
	}

}
