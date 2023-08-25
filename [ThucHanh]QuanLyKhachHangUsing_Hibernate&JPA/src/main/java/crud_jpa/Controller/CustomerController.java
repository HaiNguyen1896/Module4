package crud_jpa.Controller;

import crud_jpa.Model.Customer;
import crud_jpa.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customers")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Customer>customerList = customerService.findAll();
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }
    @GetMapping("/customers/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/customers/create")
    public ModelAndView create(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.save(customer);
        return modelAndView;
    }
    @GetMapping("/customers/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer",customerService.findCustomerByID(id));
        return modelAndView;
    }
    @PostMapping("/customers/edit")
    public ModelAndView editForm(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.edit(customer);
        return modelAndView;
    }
    @GetMapping("/customers/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        Customer customer = customerService.findCustomerByID(id);
        customerService.remove(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @GetMapping("/customers/view/{id}")
    public ModelAndView view(@PathVariable int id){
        Customer customer = customerService.findCustomerByID(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

}
