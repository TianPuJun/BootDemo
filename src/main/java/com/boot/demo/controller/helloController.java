package com.boot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author cui
 * @create 2018-07-24 9:25
 **/
@RestController
public class helloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello啊abcdefg";
    }
}
