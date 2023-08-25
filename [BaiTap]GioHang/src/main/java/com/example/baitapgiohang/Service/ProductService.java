package com.example.baitapgiohang.Service;

import com.example.baitapgiohang.Model.Product;
import com.example.baitapgiohang.Repository.IProductRepo;
import com.example.baitapgiohang.Service.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo iProductRepo;
    @Override
    public void add(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public Product findProductByID(long id) {
       return iProductRepo.findById(id).get();
    }

    @Override
    public List<Product> findAllProduct() {
        return iProductRepo.findAll();
    }
}
