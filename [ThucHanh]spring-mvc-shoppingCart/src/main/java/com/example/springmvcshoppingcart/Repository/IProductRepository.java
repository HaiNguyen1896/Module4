package com.example.springmvcshoppingcart.Repository;

import com.example.springmvcshoppingcart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {

}
