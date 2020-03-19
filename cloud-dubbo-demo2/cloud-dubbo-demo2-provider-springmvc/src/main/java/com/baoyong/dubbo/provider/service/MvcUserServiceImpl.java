package com.baoyong.dubbo.provider.service;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注意此处dubbo的一二种方式调用时还是需要配置访问路径的
 *
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@org.apache.dubbo.config.annotation.Service(protocol = {"dubbo"}, version = "1.0.0")
@RestController
public class MvcUserServiceImpl implements UserService {
    @Override
    public UserDto getUserInfo(Integer id) {
        return new UserDto().setId(id).setAge((short) 27).setName("江宝勇").setMessage("mvc");
    }

    @Override
    public Integer addUserInfo(UserDto userDto) {
        System.out.println(userDto.toString());
        return 0;
    }
}
