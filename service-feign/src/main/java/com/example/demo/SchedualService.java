package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 赵金鑫
 * @date 2017年08月28日
 */

//value为服务客户端名称，指定Hystrix的fallback类
@FeignClient(value = "service-client", fallback = SchedualServiceHystric.class)
public interface SchedualService {

    @GetMapping(value = "/testPort")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
