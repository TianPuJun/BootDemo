package com.boot.demo.controller;


import com.boot.demo.bean.Users;
import com.boot.demo.service.UsersService;
import com.boot.demo.util.MD5Encoder;
import com.boot.demo.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
