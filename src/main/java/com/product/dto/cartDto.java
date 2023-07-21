package com.product.dto;

import java.util.List;

public class cartDto {
	List<CartItemDto> cartItems;
	private double totalCost;
	public cartDto() {
		super();
	}
	public List<CartItemDto> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	

}
