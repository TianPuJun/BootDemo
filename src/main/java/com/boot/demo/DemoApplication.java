package com.boot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
//@MapperScan({"com.boot.demo.dao"})
public class DemoApplication {
    //测试一下
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
