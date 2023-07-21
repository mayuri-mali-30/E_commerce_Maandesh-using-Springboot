package com.product.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.OnError;


@Entity
@Table(name="tokens")
public class AuthenticationToken {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column(name = "id")
	private int id;
	private String token;
	@Column(name = "created_date")
	private Date createdDate;
	@OneToOne(targetEntity =user.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name="user_id")
	private user  user;
	
	public AuthenticationToken(int id, String token, Date createdDate, com.product.model.user user) {
		super();
		this.id = id;
		this.token = token;
		this.createdDate = createdDate;
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public AuthenticationToken(com.product.model.user user) {
		super();
		this.user = user;
		this.createdDate=(Date) new Date(id);
		this.token=UUID.randomUUID().toString();
	}
	public AuthenticationToken() {
		super();
	}
	
	
	
	

}
