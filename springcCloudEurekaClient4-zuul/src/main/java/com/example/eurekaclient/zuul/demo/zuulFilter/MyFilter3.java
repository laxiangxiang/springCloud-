package com.example.eurekaclient.zuul.demo.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFilter3 extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(MyFilter3.class);

    @Override
    public String filterType() {
        log.info(this.getClass().getName());
        return "post";
    }

    @Override
    public int filterOrder() {
        return 3;
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
