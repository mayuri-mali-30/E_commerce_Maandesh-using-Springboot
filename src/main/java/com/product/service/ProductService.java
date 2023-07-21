package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.dto.ProductDto;
import com.product.exceptions.ProductNotExistException;
import com.product.model.Category;
import com.product.model.product;
import com.product.repository.productRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class ProductService {
	@Autowired
	private productRepository productRepository;

	public void createProduct(ProductDto productDto, Category category) {
		product product = new product();
		product.setDescription(productDto.getDescription());
		product.setIamgeurl(productDto.getIamgeurl());
		product.setName(productDto.getName());
		product.setCategory(category);
		product.setPrice(productDto.getPrice());
		productRepository.save(product);

	}

	public ProductDto getProductDto(product product) {
		ProductDto ProductDto = new ProductDto();
		ProductDto.setDescription(product.getDescription());
		ProductDto.setIamgeurl(product.getIamgeurl());
		ProductDto.setName(product.getName());
		ProductDto.setCategoryId(product.getCategory().getId());
		ProductDto.setPrice(product.getPrice());
		ProductDto.setId(product.getId());
		return ProductDto;

	}

	public List<ProductDto> getAllProducts() {
		List<product> allList = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for (product product : allList) {
			productDtos.add(getProductDto(product));
		}
		return productDtos;
	}

	public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
		Optional<product> product = productRepository.findById(productId);
		if (!product.isPresent()) {
			throw new Exception("product not present");
		}
		product product2 = product.get();
		product2.setDescription(productDto.getDescription());
		product2.setIamgeurl(productDto.getIamgeurl());
		product2.setName(productDto.getName());
		product2.setPrice(productDto.getPrice());
		productRepository.save(product2);

	}

	public product findById(Integer id) throws ProductNotExistException {
		Optional<product> product = productRepository.findById(id);
		if (product == null) {
			throw new ProductNotExistException("Product id is invalid:" + id);
		}
		return product.get();

	}
	

}
