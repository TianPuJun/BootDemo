package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 测试
 *
 * @author cui
 * @create 2018-07-24 9:25
 **/
@Controller
@RequestMapping("/rest")
public class helloController {
    @GetMapping("/hello")
    public ModelAndView hello(Map<String,Object> map){
        map.put("userName","用户名啊");
        map.put("passWorld","123455");

        ModelAndView mv = new ModelAndView();
        mv.addObject("testValue","测试传值方法二");
        mv.setViewName("index");
        return mv;
        //return "index";

    }
    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("testValue","测试ModelAndView传值方法二");
        mv.setViewName("index");
        return mv;
    }
    @GetMapping("/ex")
    public String a() throws Exception {
        throw new Exception("test");
    }
}
