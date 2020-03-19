package com.baoyong.dubbo.consumer.controller;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.consumer.config.exception.ServiceException;
import com.baoyong.dubbo.dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangBaoyong
 * @date 2020/03/19
 **/
@RestController
@RequestMapping("/user05")
public class UserController05 {
    @Reference(version = "1.0.0", protocol = "dubbo", validation = "true")
    private UserService userService;

    @GetMapping("/get")
    public UserDto getInfo(Integer id) {
        return userService.getUserInfo(id);
    }

    @PostMapping("/add")
    public Integer addUser(UserDto userDto) {
        return userService.addUserInfo(userDto);
    }

    @GetMapping("/exception")
    public Integer getException() {
        if (true) {
            throw new ServiceException(406, "阿伟死了");
        }
        return 0;
    }
}
