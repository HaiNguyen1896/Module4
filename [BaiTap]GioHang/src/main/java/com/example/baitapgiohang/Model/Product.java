package com.example.baitapgiohang.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true)
    private String productCode;
    @Column(nullable = false)
    private double price;
    @Column(nullable = true)
    private String img;
    @ManyToOne
    @JoinColumn(name="detailOrder_id")
    DetailOrder detailOrder;
}
