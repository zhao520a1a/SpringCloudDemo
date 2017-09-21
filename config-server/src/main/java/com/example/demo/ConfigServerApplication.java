package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableConfigServer  //注解开启配置服务器的功能
@EnableEurekaClient
@SpringBootApplication
public class ConfigServerApplication {

	/*
                        /{application}/{profile}[/{label}]
    增加profile参数，http://localhost:8888/my-client/uat/master
    yml格式，http://localhost:8888/my-client.yml
    properties格式，http://localhost:8888/my-client.properties


    {application}映射到Config客户端的spring.application.name属性
    {profile}映射到Config客户端的spring.profiles.active属性，可以用来区分环境
    {label}映射到Git服务器的commit id, 分支名称或者tag，默认值为master

       访问http://localhost:9999/foo/dev
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
