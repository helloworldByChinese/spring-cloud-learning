package com.baoyong.dubbo.consumer.controller;

import com.baoyong.dubbo.consumer.dto.UserDtoRibbon;
import com.baoyong.dubbo.consumer.feign.UserFeignClient02;
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
@RequestMapping("/user02")
public class UserController02 {
    @Autowired
    private UserFeignClient02 userFeignClient02;

    @GetMapping("/get")
    public UserDtoRibbon getInfo(@RequestParam("id") Integer id) {
        return userFeignClient02.getInfo(id);
    }
}
