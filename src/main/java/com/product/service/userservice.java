package com.product.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ResponseDto;
import com.product.dto.SignInDto;
import com.product.dto.SigninResponseDto;
import com.product.dto.SignupDto;
import com.product.exceptions.AuthenticationFailException;
import com.product.exceptions.CustomException;
import com.product.model.AuthenticationToken;
import com.product.model.user;
import com.product.repository.UserRepository;

@Service
public class userservice {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthenticationService authenticationService;
	@Transactional

	public ResponseDto signup(SignupDto signupDto) {
		ResponseDto responseDto=new ResponseDto("success","dumy response");
		if(userRepository.findByEmail(signupDto.getEmail()) != null)
		{
			throw new CustomException("user already present");
			
		}
		//hash the password
		String encryptedpassword=signupDto.getPassword();
		try {
			encryptedpassword=hashPassword(signupDto.getPassword());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		user user=new user(signupDto.getFirstname(),signupDto.getLastname(),signupDto.getEmail(),encryptedpassword);
		userRepository.save(user);
		//create the token
	final AuthenticationToken authenticationToken=	new AuthenticationToken(user);
	authenticationService.saveConfirmationToken(authenticationToken);
		
		return responseDto;
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest=md.digest();
		String hash=DatatypeConverter
				.printHexBinary(digest).toUpperCase();
		return hash;
		
		
	}

	public SigninResponseDto signIn(SignInDto signInDto) {
		//find user by email
		user user=userRepository.findByEmail(signInDto.getEmail());
		if(user==null)
		{
			throw new AuthenticationFailException("User is not valid...");
		}
		
		//hash the password
		try {
			if(!user.getPassword().equals(hashPassword(signInDto.getPassword())))
				{
				throw new AuthenticationFailException("Wrong Password...");
					
				};
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//compare the password 
		
		//if password match
		
		AuthenticationToken token=authenticationService.getToken(user);
		// retrive the token 
		
		if(token==null)
		{
			throw new CustomException("Token is not present ");
		}
		return new SigninResponseDto("success", token.getToken());
		//return the step
		
	}

	
	
}
