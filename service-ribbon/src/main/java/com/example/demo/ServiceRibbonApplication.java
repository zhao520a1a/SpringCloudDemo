package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrixDashboard //使用Hystrix仪表盘
@EnableHystrix  //使用Hystrix
@EnableDiscoveryClient  //向eureka服务中心注册
@SpringBootApplication
public class ServiceRibbonApplication {
    //   http://localhost:8880/testRibbon?name=Golden
	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced  //开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
