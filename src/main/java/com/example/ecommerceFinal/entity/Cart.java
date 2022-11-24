package com.example.ecommerceFinal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private short totalPrice;
    private short totalQuantity;
    @OneToMany(mappedBy = "cart")
    private Set<ProductLine> listOfProductLines;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
