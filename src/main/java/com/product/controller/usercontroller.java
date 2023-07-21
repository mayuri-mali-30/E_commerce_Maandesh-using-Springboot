package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ResponseDto;
import com.product.dto.SignInDto;
import com.product.dto.SigninResponseDto;
import com.product.dto.SignupDto;
import com.product.exceptions.CustomException;
import com.product.service.userservice;

@RequestMapping("/user")
@RestController
public class usercontroller {
	@Autowired
	userservice userservice;

	@PostMapping("/signup")
	public ResponseDto signup(@RequestBody SignupDto signupDto)
	{
		try {
			
			return userservice.signup(signupDto);
		} catch (Exception e) {
			throw new CustomException("Something went wrong");
		}
		
	}
	@PostMapping("/signin")
	public SigninResponseDto signin(@RequestBody SignInDto signInDto) {
		return userservice.signIn(signInDto);
	}

}
