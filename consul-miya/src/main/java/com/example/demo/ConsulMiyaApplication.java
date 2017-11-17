package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableDiscoveryClient  //开启服务发现
@SpringBootApplication
public class ConsulMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulMiyaApplication.class, args);
	}


	@RequestMapping("/test")
	public String test(){
		return "Hi, I'm consul-miya!";
	}

}
