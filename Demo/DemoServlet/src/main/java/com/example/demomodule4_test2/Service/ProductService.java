package com.example.demomodule4_test2.Service;

import com.example.demomodule4_test2.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
  public   List<Product> productList;
    public ProductService(){
        productList=new ArrayList<>();
        productList.add(new Product(1, "Người yêu Quang", 200, "https://muabanre.net/wp-content/uploads/2023/06/gai-xinh-in4-vsbg-14.jpg"));
        productList.add(new Product(2, "Người yêu Minh", 300, "https://gamek.mediacdn.vn/133514250583805952/2021/12/18/photo-1-1639800841076808022272.jpg"));
        productList.add(new Product(3, "Người yêu Hảo", 200, "https://voz.vn/attachments/91521840_307101980289524_4067317154385494016_n-png.38616/"));
    }

    public Product findProductByID(int id){
        for (Product product:productList){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    public void editProduct(Product product){
        Product product1 = findProductByID(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setImg(product.getImg());
    }
    public void deleteProduct(int id){
        for (int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==id){
                productList.remove(i);
            }
        }
    }
    public void add(Product product){
        productList.add(product);
    }
    public List<Product>findProduct(String keyword){
        List<Product>tempProduct = new ArrayList<>();
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getName().toLowerCase().contains(keyword.toLowerCase())){
                tempProduct.add(productList.get(i));
            }
        }
        return tempProduct;
    }
}
