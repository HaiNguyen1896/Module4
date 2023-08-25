package Controller;
import Model.Customer;
import Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public String home(Model model){
        model.addAttribute("product",customerService.customerList);
        return "home";
    }
    @GetMapping("/customers/showEdit")
    public String showEdit(int id,Model model){
        model.addAttribute("customer",customerService.findCustomerByID(id));
        return "info";
    }

    @PostMapping("/customers/edit")
    public String edit(int id,String name,String email,String address){
        customerService.edit(new Customer(id,name,email,address));
        return "redirect:/customers";
    }
}
