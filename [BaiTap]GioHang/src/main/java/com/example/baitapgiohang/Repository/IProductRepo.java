package com.example.baitapgiohang.Repository;

import com.example.baitapgiohang.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Long> {
}
