package com.example.ungdungkiemtraemailgradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    public EmailController(){
        pattern= Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping(value = "index")
    public String home() {
        return "index";
    }

    @PostMapping(value = "/validate")
    public String user(@RequestParam String email, Model model){
        boolean isValid = validate(email);
        if(!isValid){
            model.addAttribute("message","email is invalid");
            return "index";
        }
        model.addAttribute("email",email);
        return "home";
    }


    private boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
