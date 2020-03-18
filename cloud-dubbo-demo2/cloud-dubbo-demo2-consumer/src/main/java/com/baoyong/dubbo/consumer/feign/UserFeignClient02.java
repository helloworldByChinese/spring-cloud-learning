package com.baoyong.dubbo.consumer.feign;

import com.baoyong.dubbo.consumer.dto.UserDtoRibbon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 方式二：
 *      Feign + Ribbon
 *      因为是 HTTP 接口的调用，所以实际无需引入 api项目的jar包 依赖
 *
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@FeignClient(name = "demo-dubbo-provider")
public interface UserFeignClient02 {
    @GetMapping("/user/get")
    UserDtoRibbon getInfo(@RequestParam("id") Integer id);
}
