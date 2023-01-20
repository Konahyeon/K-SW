package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping(value = "/") //index.html로 가라
    private String index() {
        return "/index.html";
    }

    @GetMapping(value = "/login")
    private String login() {
        return "/login.html";
    }

    @GetMapping(value = "/register")
    private String register() {
        return "/register.html";
    }

    @GetMapping(value = "/product")
    private String home() {
        return "/product.html";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {

        session.invalidate(); //사용자에게 부여했던 session 삭제
        return "/login.html";
    }
}
