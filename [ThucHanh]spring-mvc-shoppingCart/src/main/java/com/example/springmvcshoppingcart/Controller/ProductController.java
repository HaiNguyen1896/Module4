package com.example.springmvcshoppingcart.Controller;

import com.example.springmvcshoppingcart.Model.Cart;
import com.example.springmvcshoppingcart.Model.Product;
import com.example.springmvcshoppingcart.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    HttpSession httpSession;
    Cart cart;
    public ProductController(){
        this.cart = new Cart();
    }
//    @ModelAttribute("cart")
//    public Cart setupCart() {
//        return new Cart();
//    }
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/views/home");
        modelAndView.addObject("listProduct",iProductService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id,
                          @RequestParam("action")String action){
        Product product = iProductService.findByID(id);
        if(action.equals("show")){
            cart.addProduct(product);
            httpSession.setAttribute("cart",cart);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        httpSession.setAttribute("cart",cart);
        return "redirect:/home";

    }
}
