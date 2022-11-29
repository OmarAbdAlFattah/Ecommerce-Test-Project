package com.example.ecommerceFinal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
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
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<ProductLine> listOfProductLines;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(short totalPrice) {
        this.totalPrice = totalPrice;
    }

    public short getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(short totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Set<ProductLine> getListOfProductLines() {
        return listOfProductLines;
    }

    public void setListOfProductLines(Set<ProductLine> listOfProductLines) {
        this.listOfProductLines = listOfProductLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
