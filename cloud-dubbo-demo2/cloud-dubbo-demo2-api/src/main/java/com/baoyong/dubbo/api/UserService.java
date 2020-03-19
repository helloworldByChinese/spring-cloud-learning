package com.baoyong.dubbo.api;

import com.baoyong.dubbo.dto.UserDto;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
public interface UserService {

    UserDto getUserInfo(Integer id);

    /**
     * 新增用户
     *
     * @param userDto user
     * @return Integer
     */
    Integer addUserInfo(UserDto userDto);

}
