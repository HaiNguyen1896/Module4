package com.example.demopostman.Controller;
import com.example.demopostman.Model.Account;
import com.example.demopostman.Service.AccountService;
import com.example.demopostman.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*") //chấp nhận các port khác ( VD: Port của HTML Ajax khác với local Host 8080 có thể truy cập nếu không sẽ lỗi  CORS )
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;


    @GetMapping("/getall")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/find/{id}")
    public Account findAccountByID(@PathVariable int id) {
        return accountService.findAccountByID(id);
    }

    @PostMapping("/create")
    public void save(@RequestBody Account account) {
        accountService.save(account);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        accountService.delete(id);
        return "ok";
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Account account) {
        accountService.save(account);
        return "Đã sửa";
    }
    @GetMapping("/findByName/{keyword}")
    public List<Account> findAccountByID(@PathVariable String keyword) {
        List<Account>accountList = accountService.findAccountNameByKeyword(keyword);
        return accountList;
    }
    @PostMapping("/login")
    public Account login(@RequestBody Account account){
        Account accountLogin = accountService.findAccount(account.getUsername(),account.getPassword());
        return accountLogin;
    }
    @PostMapping("/register")
    public void registerAccount(@RequestBody Account account){
        accountService.save(account);
    }
}