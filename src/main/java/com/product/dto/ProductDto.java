package com.product.dto;

import javax.validation.constraints.NotNull;

import com.product.model.Category;

public class ProductDto {
	//create it can be optional
	//for update we need the id
	private Integer id;
	private @NotNull String name;
	private @NotNull String iamgeurl;
	private @NotNull double price;
	private @NotNull String description;
	private @NotNull Integer categoryId;
	
	
	public ProductDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIamgeurl() {
		return iamgeurl;
	}
	public void setIamgeurl(String iamgeurl) {
		this.iamgeurl = iamgeurl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
