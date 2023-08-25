package com.example.baitapgiohang.Service.IService;

import com.example.baitapgiohang.Model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void edit(Product product);
    Product findProductByID(long id);
    List<Product>findAllProduct();
}
