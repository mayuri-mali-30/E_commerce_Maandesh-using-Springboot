package com.product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.common.ApiResponce;
import com.product.model.Category;
import com.product.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/create")
	public ResponseEntity<ApiResponce> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<>(new ApiResponce(true, "Create a new category"),HttpStatus.CREATED);
		
		
		
	}
	@GetMapping("/list")
	public List<Category> ListallCategory() {
		return categoryService.ListCategory();	
	}
	@PostMapping("/update/{categoryId}")
	public ResponseEntity<ApiResponce> updateCategory(@PathVariable("categoryId")int categoryId,@RequestBody Category category)
	{
		if(!categoryService.findById(categoryId)){
			return new ResponseEntity<>(new ApiResponce(false, "category doesnt exitst"),HttpStatus.NOT_FOUND);
		}
		
		categoryService.editcategory(categoryId,category);
		return new ResponseEntity<>(new ApiResponce(true, "category has been updated"),HttpStatus.CREATED);
	}
	

}
