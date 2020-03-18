package com.baoyong.dubbo.consumer.controller;

import com.baoyong.dubbo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@RestController
@RequestMapping("/user03")
public class UserController03 {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public UserDto getInfo(@RequestParam("id") Integer id) {
        String url = String.format("http://%s/user/get?id=%d", "demo-dubbo-provider", id);
        return restTemplate.getForObject(url, UserDto.class);
    }
}
