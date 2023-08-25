package com.example.demomodule4_test2.Controller;
import com.example.demomodule4_test2.Model.Product;
import com.example.demomodule4_test2.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class home {
    ProductService productService = new ProductService();
    @GetMapping("/products")
    public String home(Model model){
        model.addAttribute("products",productService.productList);
        return "home";
    }
    @GetMapping("/products/edit")
    public String showEdit(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findProductByID(id));
        return "edit";
    }
    @PostMapping("/products/edit")
    public String edit(@RequestParam int id,String name,double price,String img){
        productService.editProduct(new Product(id,name,price,img));
        return "redirect:/products";
    }

    @GetMapping("products/remove")
    public String deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    @GetMapping("/products/add")
    public String showAdd(){
        return "add";
    }
    @PostMapping("/products/add")
    public String Add(@RequestParam int id,String name,double price,String img){
        productService.add(new Product(id,name,price,img));
        return "redirect:/products";
    }
    @GetMapping("/products/find")
    public String findProduct(@RequestParam String keyword,Model model){
       model.addAttribute("products",productService.findProduct(keyword));
       return "home";
    }
}
