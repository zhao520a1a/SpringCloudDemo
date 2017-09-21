package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy  //开启zuul的功能
@EnableEurekaClient
@SpringBootApplication
public class ServiceZullApplication {

	//http://localhost:8890/api-a/testRibbon?name=Golden1&token=22
	//http://localhost:8890/api-b/testFeign?name=Golden1&token=22
	public static void main(String[] args) {
		SpringApplication.run(ServiceZullApplication.class, args);
	}
}
