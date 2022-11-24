package com.example.ecommerceFinal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_generator")
    private Long id;
    private String name;
    private String description;
    private short price;

    @OneToMany(mappedBy = "product")
    private Set<ProductLine> productLineSet;


    public Product(Long productId) {
        this.id = productId;
    }
}
