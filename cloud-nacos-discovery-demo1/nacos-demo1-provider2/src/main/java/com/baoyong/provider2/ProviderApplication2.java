package com.baoyong.provider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangBaoyong
 * @date 2020/03/17
 **/
@SpringBootApplication
public class ProviderApplication2 {
    private static final String APP_NAME = "provider2";

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication2.class, args);
    }

    @RestController
    static class HelloController {
        @RequestMapping("/hello")
        public String hello() {
            System.out.println("hello world!");
            return "hello" +APP_NAME;
        }
    }
}
