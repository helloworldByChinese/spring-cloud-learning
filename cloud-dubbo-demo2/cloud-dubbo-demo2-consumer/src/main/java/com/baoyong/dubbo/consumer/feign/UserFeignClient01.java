package com.baoyong.dubbo.consumer.feign;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.baoyong.dubbo.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * \@DubboTransported 注解的目的，是将原本使用 Feign 进行服务调用的 Spring Cloud 项目，逐步迁移到使用 Dubbo 进行服务调用
 * 服务调用方式一：Feign + Dubbo
 *
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@FeignClient(name="demo-dubbo-provider")
@DubboTransported(protocol = "dubbo")
public interface UserFeignClient01 {
    @GetMapping("/user/get")
    UserDto getInfo(@RequestParam("id") Integer id);
}
