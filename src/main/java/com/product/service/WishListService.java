package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.common.ApiResponce;
import com.product.dto.ProductDto;
import com.product.model.WishList;
import com.product.model.user;
import com.product.repository.WishListRepository;

@Service
public class WishListService {
	@Autowired
	WishListRepository wishListRepository;
	@Autowired
	ProductService productService;

	public ResponseEntity<ApiResponce> createWishList(WishList wishList) {
		wishListRepository.save(wishList);
		ApiResponce apiResponce=new ApiResponce(true, "added to wishlist");
		return new ResponseEntity<>(apiResponce,HttpStatus.CREATED);
		
	}

	public List<ProductDto> getWishListForUser(user user1) {
	       final List<WishList>  wishLists= wishListRepository.findAllByUserIdOrderByCreateDateDesc(user1);
	       List<ProductDto> productsDtos=new ArrayList<>();
	       for(WishList wishlist:wishLists)
	       {
	    	   productsDtos.add(productService.getProductDto(wishlist.getProduct()));
	       }
		return productsDtos;
		
	}

}
