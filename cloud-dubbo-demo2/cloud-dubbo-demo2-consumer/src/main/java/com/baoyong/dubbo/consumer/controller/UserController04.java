package com.baoyong.dubbo.consumer.controller;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangBaoyong
 * @date 2020/03/19
 **/
@RestController
@RequestMapping("/user04")
public class UserController04 {
    @Reference(version = "1.0.0", protocol = "dubbo")
    private UserService userService;

    @GetMapping("/get")
    public UserDto getInfo(Integer id) {
        return userService.getUserInfo(id);
    }

}
