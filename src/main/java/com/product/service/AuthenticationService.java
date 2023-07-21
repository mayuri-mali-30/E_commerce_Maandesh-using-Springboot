package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exceptions.AuthenticationFailException;
import com.product.model.AuthenticationToken;
import com.product.model.user;
import com.product.repository.TokenRepository;

@Service
public class AuthenticationService {
	@Autowired
	TokenRepository tokenRepository;

	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		tokenRepository.save(authenticationToken);

	}

	public AuthenticationToken getToken(user user) {
		// TODO Auto-generated method stub
		return tokenRepository.findByUser(user);
	}

	public user getuser(String token) {
		final AuthenticationToken AuthenticationToken = tokenRepository.findByToken(token);
		if (token == null) {
			return null;

		}
		// authentication is not null
		return AuthenticationToken.getUser();

	}

	public void authenticate(String token) {
		if (token == null) {
			// throw an exception
			throw new AuthenticationFailException("Token not present");
		}
		if(getuser(token)==null)
		{
			throw new AuthenticationFailException("token not valid");
		}
	}

}
