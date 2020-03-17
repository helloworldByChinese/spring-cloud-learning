package com.baoyong.consumer1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @author JiangBaoyong
 * @date 2020/03/17
 **/
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Configuration
    public class RestTemplateConfiguration {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    @RestController
    static class TestController {
        @Autowired
        private DiscoveryClient discoveryClient;
        @Autowired
        private RestTemplate restTemplate;
        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @GetMapping("/hello")
        public String hello() {
            // 1.手动选择一个实例进行访问
//            ServiceInstance instance = getByYourSelf();

            // 2.负载均衡自动随机加载
            ServiceInstance instance = loadBalancerClient.choose("demo1-provider");

            String url = instance.getUri() + "/hello";

            String response = restTemplate.getForObject(url, String.class);

            return "consumer:" + response;
        }

        private ServiceInstance getByYourSelf() {
            // 1.手动选择一个实例进行访问
            List<ServiceInstance> list = discoveryClient.getInstances("demo1-provider");
            int index = (int) (Math.random() *list.size());
            ServiceInstance instance = list.get(index);
            if (Objects.isNull(instance)) {
                throw new IllegalStateException("找不到对应的微服务");
            }
            return instance;
        }

    }
}
