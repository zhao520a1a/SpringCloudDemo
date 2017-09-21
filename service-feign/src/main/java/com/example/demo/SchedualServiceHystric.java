package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author 赵金鑫
 * @date 2017年08月28日
 */
@Component
public class SchedualServiceHystric  implements SchedualService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "fallbackError: " + name + ",sorry,error!";
    }
}