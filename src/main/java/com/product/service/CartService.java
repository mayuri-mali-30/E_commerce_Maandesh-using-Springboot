package com.product.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.AddToCartDto;
import com.product.dto.CartItemDto;
import com.product.dto.cartDto;
import com.product.exceptions.CustomException;
import com.product.model.cart;
import com.product.model.product;
import com.product.model.user;
import com.product.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	ProductService prdProductService;
	
	@Autowired
	CartRepository cartRepository;

	public void addToCart(AddToCartDto addToCartDto, user user) {
		
	product product=	prdProductService.findById(addToCartDto.getId());
	cart cart=new cart();
	cart.setProduct(product);
	cart.setUser(user);
	cart.setQuantity(addToCartDto.getQuantity());
	cart.setCreatedDate(new Date());
	cartRepository.save(cart);
		
		
	}

	public cartDto listCartItems(user user) {
	final List<cart> carts=	cartRepository.findAllByUserOrderByCreatedDateDesc(user);
	List<CartItemDto> cartItemDtos=new ArrayList<>();
	double totalCost=0;
	for(cart cart:carts)
	{
		
		CartItemDto cartItemDto=new CartItemDto(cart);
		totalCost+=cartItemDto.getQuantity()*cart.getProduct().getPrice();
		cartItemDtos.add(cartItemDto);
	}
	cartDto cartDto=new cartDto();
	cartDto.setTotalCost(totalCost);
	cartDto.setCartItems(cartItemDtos);
		return cartDto;
	}

	public void deleteCartItem(Integer cartItemId,user user) {
		// TODO Auto-generated method stub
		Optional<cart> optionalcart=cartRepository.findById(cartItemId);
		if(optionalcart==null)
		{
			throw new CustomException("Cart item id is invalid"+cartItemId);
		}
		cart cart=optionalcart.get();
		if(cart.getUser()!=user)
		{
			throw new CustomException("cart item does not belong to user"+cartItemId);
		}
		cartRepository.delete(cart);
		
	}

}
