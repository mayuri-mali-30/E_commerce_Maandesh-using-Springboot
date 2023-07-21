package com.product.common;

import java.time.LocalDateTime;

import net.bytebuddy.asm.Advice.Local;

public class ApiResponce {
	private final boolean success;
	private final String message;
	
	public ApiResponce(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	public String getTimeStamp() {
		return LocalDateTime.now().toString();
		
	}

}
