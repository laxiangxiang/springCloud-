package com.springcloud.client.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	/**
	 * 访问接口：http://localhost:8881/hi
	 * 实际上
	 * 会去访问：http://loalhost:8888/config-client/dev/master
	 * config-server 服务会去git读取配置文件
	 * config-client从config-server获取了foo的属性，而config-server是从git仓库读取的
	 * @return
	 */
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String hi(){
		return foo;
	}
}
