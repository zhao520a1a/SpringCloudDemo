package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope  //指示Config客户端在服务器参数刷新时，也刷新注入的属性值
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	@Value("${foo}")
	String foo;
	@RequestMapping(value = "/getFooFromConfigServer")
	public String getFooFromConfigServer(){
		return foo;
	}

	@Autowired
	void setEnviroment(Environment env) {
		System.out.println("foo from env: "  + env.getProperty("foo"));
	}
}
