package com.product.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.common.ApiResponce;
import com.product.dto.AddToCartDto;
import com.product.dto.ProductDto;
import com.product.dto.cartDto;
import com.product.model.product;
import com.product.model.user;
import com.product.service.AuthenticationService;
import com.product.service.CartService;
import com.product.service.ProductService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	AuthenticationService authenticationService;
	@Autowired
	private ProductService productService;
	//post cart api
	@PostMapping("/add")
	public ResponseEntity<ApiResponce> addToCart(@RequestBody AddToCartDto addToCartDto,@RequestParam("token")String token) {
authenticationService.authenticate(token);
		
		user user=authenticationService.getuser(token);
	//	product product=productService.getuser(token);
		cartService.addToCart(addToCartDto,user);
		return new ResponseEntity<>(new ApiResponce(true,"Added to the cart "),HttpStatus.CREATED);
		
	}
	//get all cart items for a user
	@GetMapping("/")
	public ResponseEntity<cartDto> getCartItems(@RequestParam("token")String token)
	{
authenticationService.authenticate(token);
		
		user user=authenticationService.getuser(token);
		cartDto cartDto=cartService.listCartItems(user);
		return new  ResponseEntity<>(cartDto, HttpStatus.OK);
		
	}
	
	//delete a cart item for user 
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<ApiResponce> deleteCartItem(@PathVariable("cartItemId")Integer cartItemId,@RequestParam("token")String token){
authenticationService.authenticate(token);
		
		user user=authenticationService.getuser(token);
		cartService.deleteCartItem(cartItemId,user);
		return new ResponseEntity<>(new ApiResponce(true,"Item has been removed"),HttpStatus.OK);
		
	}
	
	

}
