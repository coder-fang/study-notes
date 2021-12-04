package com.example.springsecuritydemo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By  on 2021/5/17.
 */
@Controller
//@RequestMapping("/")
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        System.out.println("执行登陆方法");
        return "redirect: main.html";

    }

}
