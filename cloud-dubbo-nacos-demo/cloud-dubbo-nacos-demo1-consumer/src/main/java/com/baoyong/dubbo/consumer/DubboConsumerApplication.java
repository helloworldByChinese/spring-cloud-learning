package com.baoyong.dubbo.consumer;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@SpringBootApplication
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @RestController
    static class UserController {
        @Reference(version = "1.0.0")
        private UserService userService;

        @GetMapping("/get")
        public UserDto getInfo(@RequestParam("id") Integer id) {
            return userService.getUserInfo(id);
        }
    }
}
