package com.product.dto;

public class ResponseDto {
	private String statuString;
	private String message;
	public ResponseDto(String statuString, String message) {
		super();
		this.statuString = statuString;
		this.message = message;
	}
	public String getStatuString() {
		return statuString;
	}
	public void setStatuString(String statuString) {
		this.statuString = statuString;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
