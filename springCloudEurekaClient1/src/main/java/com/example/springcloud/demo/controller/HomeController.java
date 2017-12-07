package com.example.springcloud.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String home(@RequestParam String name){
        return "hi,"+name+",i am from port:"+port;
    }
}
