package com.product.dto;

import javax.validation.constraints.NotNull;

public class AddToCartDto {
	private @NotNull Integer id;
	private @NotNull Integer quantity;
	public AddToCartDto() {
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
	

}
