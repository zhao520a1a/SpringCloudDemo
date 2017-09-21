package com.example.demo;

import com.example.demo.test.PropertyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵金鑫
 * @date 2017年09月20日
 */

@Slf4j
@RestController
public class TestController {

    @Autowired
    //private PropertyBeanUtil propertyBeanUtil;
    private PropertyBean propertyBean;

    @RequestMapping("/test")
    public void testProperties(){
        //log.info(propertyBeanUtil.propertyBean().getUrl());
        log.info(propertyBean.getUrl());
    }
}
