package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.common.ApiResponce;
import com.product.dto.ProductDto;
import com.product.model.Category;
import com.product.model.product;
import com.product.repository.categoryrepository;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private categoryrepository categoryrepository;

	@PostMapping("/add")
	public ResponseEntity<ApiResponce> createproduct(@RequestBody ProductDto productDto) {
		Optional<Category> optionalcategory = categoryrepository.findById(productDto.getCategoryId());
		if (!optionalcategory.isPresent()) {
			return new ResponseEntity<>(new ApiResponce(false, "category doesnt exitst"), HttpStatus.BAD_REQUEST);
		}

		productService.createProduct(productDto, optionalcategory.get());
		return new ResponseEntity<>(new ApiResponce(true, "Product has been added "), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getproduct() {
		List<ProductDto> allproductdDtos = productService.getAllProducts();
		return new ResponseEntity<>(allproductdDtos, HttpStatus.OK);
	}
	@PostMapping("/update/{productId}")
	public ResponseEntity<ApiResponce> createproduct(@PathVariable("productId")Integer productId,@RequestBody ProductDto productDto) throws Exception {
		Optional<Category> optionalcategory = categoryrepository.findById(productDto.getCategoryId());
		if (!optionalcategory.isPresent()) {
			return new ResponseEntity<>(new ApiResponce(false, "category doesnt exitst"), HttpStatus.BAD_REQUEST);
		}

		productService.updateProduct(productDto, productId);
		return new ResponseEntity<>(new ApiResponce(true, "Product has been updated "), HttpStatus.OK);
	}

}
