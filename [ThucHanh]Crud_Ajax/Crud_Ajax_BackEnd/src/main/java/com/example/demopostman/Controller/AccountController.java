package com.example.demopostman.Controller;

import com.example.demopostman.Model.Account;
import com.example.demopostman.Service.AccountService;
import com.example.demopostman.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/find")
    public Account findAccountByID(@RequestBody int id) {
        return accountService.findAccountByID(id);
    }

    @PostMapping
    public void save(@RequestBody Account account) {
        accountService.save(account);
    }

    @DeleteMapping()
    public String delete(@RequestBody int id) {
        accountService.delete(id);
        return "ok";
    }

    @PutMapping
    public void edit(@RequestBody Account account) {
        accountService.save(account);
    }

    @GetMapping("/findDetailInformation")
    public String findDetail(@RequestBody int id) {
        Account account = accountService.findAccountByID(id);
        return(account.getUsername()+" and "+account.getPassword());
    }

}