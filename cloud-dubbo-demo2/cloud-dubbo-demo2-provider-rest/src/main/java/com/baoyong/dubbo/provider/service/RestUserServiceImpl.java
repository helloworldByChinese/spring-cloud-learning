package com.baoyong.dubbo.provider.service;

import com.baoyong.dubbo.api.UserService;
import com.baoyong.dubbo.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@org.apache.dubbo.config.annotation.Service(protocol = {"dubbo", "rest"}, version = "1.0.0")
@Path("/user1")
public class RestUserServiceImpl implements UserService {
    @Override
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserInfo(@QueryParam("id") Integer id) {
        return new UserDto().setId(id).setAge((short) 27).setName("江宝勇").setMessage("rest");
    }
    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer addUserInfo(UserDto userDto) {
        System.out.println(userDto.toString());
        return (int)(Math.random() * 100);
    }
}
