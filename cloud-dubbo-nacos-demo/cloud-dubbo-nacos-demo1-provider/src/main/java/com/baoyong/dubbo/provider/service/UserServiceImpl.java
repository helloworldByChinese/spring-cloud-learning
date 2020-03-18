package com.baoyong.dubbo.provider.service;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.dto.UserDto;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@org.apache.dubbo.config.annotation.Service(protocol = "dubbo", version = "1.0.0")
public class UserServiceImpl implements UserService {
    public UserDto getUserInfo(Integer id) {
        return new UserDto().setId(id).setAge((short) 27).setName("江宝勇").setMessage("test");
    }

    public Integer insertUserInfo(UserDto userDto) {
        System.out.println(userDto.toString());
        return 0;
    }
}
