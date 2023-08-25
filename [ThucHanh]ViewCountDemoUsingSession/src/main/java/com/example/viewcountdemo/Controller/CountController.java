package com.example.viewcountdemo.Controller;

import com.example.viewcountdemo.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CountController {
    @Autowired
    HttpSession httpSession;
    Count count;
    public CountController(){
        count = new Count();
    }
    @RequestMapping("/home")
    @GetMapping()
    public ModelAndView count(){
        ModelAndView modelAndView = new ModelAndView("/count");
        count.countIncrement();
        httpSession.setAttribute("countView",this.count.getCount());
        return modelAndView;
    }
}
