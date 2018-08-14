package com.boot.demo;

import com.boot.demo.util.HttpClientHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试http请求
 *
 * @author cui
 * @create 2018-08-10 16:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpTest {
    @Test
        public void a(){
            Map map = new HashMap();
            map.put("tn","90278658_hao_pg");
            HttpClientHelper.sendGet("https://www.baidu.com",map,"utf-8");
        }
}
