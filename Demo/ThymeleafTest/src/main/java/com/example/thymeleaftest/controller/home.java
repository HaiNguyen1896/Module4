package com.example.thymeleaftest.controller;

import com.example.thymeleaftest.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class home {
    @GetMapping("products")
    public String home(Model model){
//        ModelAndView modelAndView =new ModelAndView("home");
//        String name = "codegym";
//        modelAndView.addObject("name",name);
//        return modelAndView;
//        Customer customer = new Customer(1,"Hai");
//        modelAndView.addObject("customer",customer);
//        return modelAndView;
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Linh",0));
        customerList.add(new Customer(2,"Hải",1));
        customerList.add(new Customer(3,"Tuấn",2));
        customerList.add(new Customer(4,"Minh",1));
        model.addAttribute("customerList",customerList);
        return "home";
    }
}
