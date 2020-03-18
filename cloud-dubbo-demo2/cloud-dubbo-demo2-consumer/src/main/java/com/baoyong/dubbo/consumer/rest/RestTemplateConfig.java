package com.baoyong.dubbo.consumer.rest;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 方式三：RestTemplate + Dubbo
 *      本质上与方式一相同，都是底层调用dubbo
 *
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    @DubboTransported(protocol = "dubbo")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
