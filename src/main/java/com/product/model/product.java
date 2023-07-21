package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products")
public class product {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer id;
	private @NotNull String name;
	private @NotNull String iamgeurl;
	private @NotNull double price;
	private @NotNull String description;
	//many to one relationship
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnore
	Category category;
	
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
