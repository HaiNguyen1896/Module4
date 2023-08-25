package com.example.thuchanh_spring_jpa_storeproceduce.Controller;

import com.example.thuchanh_spring_jpa_storeproceduce.Model.Customer;
import com.example.thuchanh_spring_jpa_storeproceduce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/createHome")
    public ModelAndView createHome() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customers/createHome")
    public ModelAndView createHome(@ModelAttribute Customer customer) {
        boolean checkSave = customerService.saveWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        if(checkSave){
            modelAndView.addObject("message","New customer created successfully");
        }else{
            modelAndView.addObject("message","ErrorExisting");
        }
        return modelAndView;
    }
}
