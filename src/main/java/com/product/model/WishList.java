package com.product.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
public class WishList {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	@OneToOne(targetEntity = user.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private user user;
	@Column(name="created_date")
	private Date createDate;
	@ManyToOne
	@JoinColumn(name="product_id")
	private product product;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public WishList() {
		super();
	}
	public WishList(com.product.model.user user, com.product.model.product product) {
		super();
		this.user = user;
		this.product = product;
		this.createDate=new Date();
	}
	

}
