package com.example.springcloud.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    RestTemplate restTemplate;

    /**
     * 直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，
     * 根据服务实例在请求的时候会用具体的url替换掉服务名，代码如下
     *
     * @HystrixCommand对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，
     * 熔断方法直接返回了一个字符串，字符串为”hi,”+name+”,sorry,error!”
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    /**
     * 关闭 service-hi 工程,浏览器会显示：
     * hi ,forezp,orry,error!
     *
     * 这就说明当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，
     * 会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
     * @param name
     * @return
     */
    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
