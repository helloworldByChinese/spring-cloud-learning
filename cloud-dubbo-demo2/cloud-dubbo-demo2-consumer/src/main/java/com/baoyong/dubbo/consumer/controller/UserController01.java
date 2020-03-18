package com.baoyong.dubbo.consumer.controller;

import com.baoyong.dubbo.consumer.feign.UserFeignClient01;
import com.baoyong.dubbo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@RestController
@RequestMapping("/user01")
public class UserController01 {
    @Autowired
    private UserFeignClient01 userFeignClient;

    @GetMapping("/get")
    public UserDto getRestInfo(@RequestParam("id") Integer id) {
        return userFeignClient.getInfo(id);
    }
}
