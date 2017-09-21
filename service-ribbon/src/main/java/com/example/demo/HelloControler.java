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
public class HelloControler {

    @Autowired
    SchedualService schedualService;

    @RequestMapping("/testRibbon")
    public String testRibbon(@RequestParam String name){
        return schedualService.getPortFromClientOne(name);
    }

}
