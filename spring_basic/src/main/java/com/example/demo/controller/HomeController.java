package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

/*    @RequestMapping("/")
    public String home() {
        return "home";
    }*/

    @RequestMapping("/")
    public String home() {
        System.out.println("home.html");
        return "home.html";
    }
}
