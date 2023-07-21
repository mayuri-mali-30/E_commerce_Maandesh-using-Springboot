package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.repository.categoryrepository;

@Service
public class CategoryService {

	@Autowired
	private categoryrepository categoryrepository;

	public void createCategory(Category category) {
		categoryrepository.save(category);

	}
	public List<Category> ListCategory() {
	List<Category> categories=	categoryrepository.findAll();
		return categories;

	}
	public void editcategory(int categoryId, Category updateCategory) {
	  Category category=categoryrepository.getById(categoryId);
	  category.setCategoyname(updateCategory.getCategoyname());
	  category.setDescription(updateCategory.getDescription());
	  category.setImageurl(updateCategory.getImageurl());
	  categoryrepository.save(category);
		
	}
	public boolean findById(int categoryId) {
		return categoryrepository.findById(categoryId).isPresent();
		
	}

}
