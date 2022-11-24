package com.example.ecommerceFinal.repos;

import com.example.ecommerceFinal.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> { }



