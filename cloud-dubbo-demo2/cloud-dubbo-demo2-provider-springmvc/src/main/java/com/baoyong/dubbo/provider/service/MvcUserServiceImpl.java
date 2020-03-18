package com.baoyong.dubbo.provider.service;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@org.apache.dubbo.config.annotation.Service(protocol = {"dubbo"}, version = "1.0.0")
@RestController
//@RequestMapping("/user")
public class MvcUserServiceImpl implements UserService {
    @GetMapping("/get")
    public UserDto getUserInfo(Integer id) {
        return new UserDto().setId(id).setAge((short) 27).setName("江宝勇").setMessage("mvc");
    }

    public Integer insertUserInfo(UserDto userDto) {
        System.out.println(userDto.toString());
        return 0;
    }
}
