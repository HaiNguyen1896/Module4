package com.example.baitapgiohang.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @OneToMany(mappedBy = "detailOrder")
    private List<Product> products;
    @Column(nullable = false)
    private double totalPrice;
    @Column(nullable = false)
    private Date dayOrder;

    public DetailOrder(List<Product> products, double totalPrice, Date dayOrder) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.dayOrder = dayOrder;
    }

    public DetailOrder() {

    }
}
