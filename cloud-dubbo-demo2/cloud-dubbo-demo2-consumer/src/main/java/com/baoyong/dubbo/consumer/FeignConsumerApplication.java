package com.baoyong.dubbo.consumer;

import com.baoyong.dubbo.consumer.feign.UserFeignClient01;
import com.baoyong.dubbo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务调用方式一：Feign + Dubbo
 *      需要引入api接口包
 *      实际上就是使用dubbo来进行调用，根据URL路径来进行调用，若实例B不存在路径，则只会调用实例A的；
 * 方式二： Feign + Ribbon
 *      无需引入api包
 *      Ribbon调用，根据URL路径调用，实例B不存在则会报错，而不是只会调用实例一
 *  方式三：RestTemplate + Dubbo
 *       本质上与方式一相同，都是底层调用dubbo
 *  方式四：dubbo （唯一推荐方式）
 *      使用 Dubbo 调用 UserService 服务的 HTTP 接口
 *
 *  后两个方式调用就算配置路径不正确也能正常访问，而前两个当路径出错时会出现访问失败的情况
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
