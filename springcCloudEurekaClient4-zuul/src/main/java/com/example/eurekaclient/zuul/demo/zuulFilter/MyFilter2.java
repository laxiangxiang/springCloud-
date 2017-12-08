package com.example.eurekaclient.zuul.demo.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFilter2 extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(MyFilter2.class);

    @Override
    public String filterType() {
        log.info(this.getClass().getName());
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        return null;
    }
}
