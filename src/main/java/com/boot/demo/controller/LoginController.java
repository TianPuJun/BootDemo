package com.boot.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制
 *
 * @author cui
 * @create 2018-08-07 13:39
 **/
@Controller
@RequestMapping("/rest/login.do")
public class LoginController {

    @GetMapping("/info")
    public String login(){
        return "login";
    }

}
