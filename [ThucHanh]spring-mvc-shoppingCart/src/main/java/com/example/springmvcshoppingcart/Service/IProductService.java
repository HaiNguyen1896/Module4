package com.example.springmvcshoppingcart.Service;

import com.example.springmvcshoppingcart.Model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findByID(long id);
}
