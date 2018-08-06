package com.boot.demo.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 定义拦截器
 *
 * @author cui
 * @create 2018-07-24 10:13
 **/
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *此处拦截路径（/**）
         * 注意两个**。一个*号只拦截一级路径下，两个*号拦截所有
         */
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**");
        /*//将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
        registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/templates/**.css").addResourceLocations("classpath:/templates/");
        //其他静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");*/
    }

}
