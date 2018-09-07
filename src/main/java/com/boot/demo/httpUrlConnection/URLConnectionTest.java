package com.boot.demo.httpUrlConnection;


import java.util.HashMap;
import java.util.Map;

/**
 * url连接测试类
 *
 * @author cui
 * @create 2018-08-14 14:26
 **/

public class URLConnectionTest {
    public static void main(String[] args) throws Exception{
        try {
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setDefaultContentEncoding("UTF-8");
            Map map = new HashMap();
            map.put("userName","cui");
            map.put("passWord","123456");
            HttpRespons hr = httpRequest.sendPost("http://localhost:8099/rest/users.do/login",map);
            System.out.println(hr.getUrlString());
            System.out.println(hr.getProtocol());
            System.out.println(hr.getHost());
            System.out.println(hr.getPort());
            System.out.println(hr.getContentEncoding());
            System.out.println(hr.getMethod());

            System.out.println(hr.getContent());

        }catch (Exception e){
            // TODO: 2018/8/14
            e.printStackTrace();
        }
    }


}
