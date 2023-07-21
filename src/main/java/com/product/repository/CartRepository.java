package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.cart;
import com.product.model.user;

public interface CartRepository extends JpaRepository<cart, Integer> {
	List<cart> findAllByUserOrderByCreatedDateDesc(user user);

}
