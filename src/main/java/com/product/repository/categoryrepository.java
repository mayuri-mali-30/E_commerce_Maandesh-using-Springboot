package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Category;

public interface categoryrepository extends JpaRepository<Category, Integer>{

}
