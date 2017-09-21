package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 赵金鑫
 * @date 2017年08月28日
 */
@Service
public class SchedualService {

    @Autowired
    RestTemplate restTemplate;

    //@HystrixCommand注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，
    @HystrixCommand(fallbackMethod = "fallbackError")
    public String getPortFromClientOne(String name){
        //service-client为服务客户端名称，会自动被相应的url替换
        return restTemplate.getForObject("http://service-client/testPort?name=" + name, String.class);
    }

    public String fallbackError(String name) {
        return "fallbackError: "+name+",sorry,error!";
    }

}
