package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.common.ApiResponce;
import com.product.dto.ProductDto;
import com.product.model.WishList;
import com.product.model.product;
import com.product.model.user;
import com.product.service.AuthenticationService;
import com.product.service.WishListService;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
	@Autowired
private 	WishListService wishListService;
	//save product in wishlist item
	@Autowired
 private    AuthenticationService authenticationService;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponce> addToWishList(@RequestBody product product,@RequestParam("token") String token) {
		
		//authenticate the token
		authenticationService.authenticate(token);
		
		
		//find the user 
		user user=authenticationService.getuser(token);
		//save item in wishlist
		WishList wishList=new WishList(user,product);
		wishListService.createWishList(wishList);
		return new ResponseEntity<ApiResponce>(new ApiResponce(true, "Add to wishlist"), HttpStatus.CREATED);
		
		
	}
	//get all wishlist item for user 
	@GetMapping("/{token}")
	public ResponseEntity<List<ProductDto>> getWishlist(@PathVariable("token") String token)
	{
		
		authenticationService.authenticate(token);
		
		user user=authenticationService.getuser(token);
	List<ProductDto> productDtos=	 wishListService.getWishListForUser(user);
		 return new ResponseEntity<>(productDtos,HttpStatus.OK);
		
	}
	

}
