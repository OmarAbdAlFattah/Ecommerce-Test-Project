package com.example.ecommerceFinal.repos;

import com.example.ecommerceFinal.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepo extends JpaRepository<ProductLine, Long> {

}