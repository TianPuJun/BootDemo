package com.boot.demo.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 定义拦截器
 *
 * @author cui
 * @create 2018-07-24 10:13
 **/
@Configuration
public class CustomWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *此处拦截路径（/**）
         * 注意两个**。一个*号只拦截一级路径下，两个*号拦截所有
         */
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**");
    }

}
