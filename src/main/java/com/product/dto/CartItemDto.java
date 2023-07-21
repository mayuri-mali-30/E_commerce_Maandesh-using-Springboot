package com.product.dto;

import com.product.model.cart;
import com.product.model.product;

public class CartItemDto {
	private Integer id;
	private Integer quantity;
	private product product;

	public CartItemDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public CartItemDto(cart cart) {
		super();
		this.id = cart.getId();
		this.quantity=cart.getQuantity();
		this.setProduct(cart.getProduct());
	}
	

}
