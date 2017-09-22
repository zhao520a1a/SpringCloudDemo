package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope  //指示Config客户端在服务器参数刷新时，也刷新注入的属性值
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	//方式一：远程获取配置文件数据信息
	@Value("${spring.profiles.name}")
	String profilename;
	@RequestMapping(value = "/getDataFromConfigServer")
	public String getFooFromConfigServer(){
		return profilename;
	}


	//方式二：启动项目时，就从远程获取配置文件数据信息
	//@Autowired
	//void setEnviroment(Environment env) {
	//	System.out.println("从ConfigServer中获取配置文件数据: "  + env.getProperty("spring.profiles.name"));
	//}
}
