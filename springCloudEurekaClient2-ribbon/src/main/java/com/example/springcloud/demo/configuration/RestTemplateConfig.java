package com.example.springcloud.demo.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * @LoadBalanced注解表明这个restRemplate开启负载均衡的功能
     * 在client1开启两个服务（端口：8762，8763），在访问client1的接口时会依交替访问8762和8763的服务实例
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
