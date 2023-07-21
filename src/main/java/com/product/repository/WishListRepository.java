package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.WishList;
import com.product.model.user;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
	
 List<WishList> findAllByUserIdOrderByCreateDateDesc(user user);
}
