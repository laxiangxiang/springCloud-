package com.example.springcloud.demo.controller;

import com.example.springcloud.demo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    /**
     * 1.一个服务注册中心，eureka server,端口为8761
     * 2.service-hi工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册
     * 3.sercvice-ribbon端口为8764,向服务注册中心注册
     * 4.当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
