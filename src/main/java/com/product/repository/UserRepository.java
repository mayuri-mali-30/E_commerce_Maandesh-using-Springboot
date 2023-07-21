package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.user;

@Repository
public interface UserRepository extends JpaRepository<user, Integer>{
  user	findByEmail(String email);
  
}
