package com.example.baitapgiohang.Model;
import java.util.HashMap;
import java.util.Map;

public class Cart {
   public Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> selectedProduct = selectItemInCart(product);
            Integer newQuality = selectedProduct.getValue() + 1;
            products.replace(selectedProduct.getKey(), newQuality);
        }
    }
    public int totalQuantity(){
        return products.size();
    }
    public double countTotalPayment(){
        double payment = 0;
        for(Map.Entry<Product,Integer>product : products.entrySet()){
            payment += product.getKey().getPrice()*product.getValue();
        }
        return payment;
    }
}
