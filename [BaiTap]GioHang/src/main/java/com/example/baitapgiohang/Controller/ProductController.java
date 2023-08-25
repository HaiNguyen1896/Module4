package com.example.baitapgiohang.Controller;

import com.example.baitapgiohang.Model.Cart;
import com.example.baitapgiohang.Model.DetailOrder;
import com.example.baitapgiohang.Model.Product;
import com.example.baitapgiohang.Service.IService.IDetailOrderService;
import com.example.baitapgiohang.Service.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IDetailOrderService iDetailOrderService;
    @Autowired
    HttpSession httpSession;
    Cart cart;
    public ProductController(){
        this.cart = new Cart();
    }

    @GetMapping("/home")
    public String shopMainPage(Model model){
        List<Product> productList = iProductService.findAllProduct();
        model.addAttribute("productList",productList);
        return ("/views/index");
    }
    @GetMapping("/home/cart/{id}")
    public String addToCart(Model model, @PathVariable long id, @RequestParam ("action")String action){
        Product product = iProductService.findProductByID(id);
        if(action.equals("show")){
            cart.addProduct(product);
            httpSession.setAttribute("cart",cart);
            return "redirect:/home/showCart";
        }
        cart.addProduct(product);
        httpSession.setAttribute("cart",cart);
        return "redirect:/home";
    }
    @GetMapping("/home/showCart")
    public String mainPageCart(Model model){
        Cart cart = (Cart) httpSession.getAttribute("cart");
      model.addAttribute("cartList",cart);
        return "/views/cart";
    }
    @GetMapping("/home/checkout")
    public String checkout(Model model){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        double totalPrice = cart.countTotalPayment();
        Date curentDate = new Date();
        List<Product>products= new ArrayList<>();
        for(Map.Entry<Product, Integer>product : cart.products.entrySet()){
            Product product1 = iProductService.findProductByID(product.getKey().getId());
            products.add(product1);
        }
        DetailOrder detailOrder = new DetailOrder(products,totalPrice,curentDate);
        iDetailOrderService.add(detailOrder);
        model.addAttribute("detailProduct",detailOrder);
        return "views/DetailOrder";
    }

}
