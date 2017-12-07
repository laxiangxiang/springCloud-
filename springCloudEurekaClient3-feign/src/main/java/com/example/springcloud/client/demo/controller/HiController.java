package com.example.springcloud.client.demo.controller;

import com.example.springcloud.client.demo.ScheduleServiceHi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {

    @Resource
    ScheduleServiceHi scheduleServiceHi;

    /**
     * 多次访问http://localhost:8765/hi?name=forezp,浏览器交替显示，访问不同端口号上的实例
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return scheduleServiceHi.sayHiFromClientOne(name);
    }
}
