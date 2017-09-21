package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵金鑫
 * @date 2017年08月28日
 */

@RestController
public class HelloController {
    @Autowired
    SchedualService schedualService;

    @RequestMapping(value = "/testFeign")
    public String testFeign(@RequestParam String name){
        return "Service-Feign 调用 eureka-client :" + schedualService.sayHiFromClientOne(name);
    }
}
