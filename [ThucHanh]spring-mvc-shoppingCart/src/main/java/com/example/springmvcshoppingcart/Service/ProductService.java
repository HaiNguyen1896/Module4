package com.example.springmvcshoppingcart.Service;

import com.example.springmvcshoppingcart.Model.Product;
import com.example.springmvcshoppingcart.Repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
       return iProductRepository.findAll();
    }

    @Override
    public Product findByID(long id) {
        return iProductRepository.findById(id).get();
    }
}
