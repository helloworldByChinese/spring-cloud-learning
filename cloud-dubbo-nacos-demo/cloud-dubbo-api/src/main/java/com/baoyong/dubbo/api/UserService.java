package com.baoyong.dubbo.api;

import com.baoyong.dubbo.dto.UserDto;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
public interface UserService {

    UserDto getUserInfo(Integer id);

    Integer insertUserInfo(UserDto userDto);

}
