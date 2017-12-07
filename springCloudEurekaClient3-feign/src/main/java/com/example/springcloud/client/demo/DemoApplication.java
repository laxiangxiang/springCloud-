package com.example.springcloud.client.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//@EnableFeignClients注解开启Feign的功能

@EnableHystrixDashboard//@EnableHystrixDashboard注解，开启hystrixDashboard(hystrix仪表盘)
@EnableCircuitBreaker
//访问http://localhost:8765/hystrix出现仪表盘界面（ribbon配置方法相同）
//http://localhost:8765/hystrix.stream
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
