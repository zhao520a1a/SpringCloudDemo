package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient  //eureka client
@SpringBootApplication
@RestController

//public class EurekaClient1Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(EurekaClient1Application.class, args);
//	}
//
//	@Value("${server.port}")
//	String port;
//
//	@RequestMapping("/testPort")
//	public String home (@RequestParam String name){
//		return "hi " + name + ", I am from port:" + port;
//	}
//}

public class EurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2Application.class, args);
	}

	@Value("${server.port}")
	String port ;

	@RequestMapping("/testPort")
	public String home (@RequestParam String name){
		return "hi " + name + ", I am from port:" + port;
	}
}
