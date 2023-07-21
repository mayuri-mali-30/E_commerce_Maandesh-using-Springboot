package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.product;

public interface productRepository extends JpaRepository<product, Integer>{

}
