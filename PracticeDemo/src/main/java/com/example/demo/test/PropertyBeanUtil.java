package com.example.demo.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 赵金鑫
 * @date 2017年09月20日
 */

@Component
@Configuration
@EnableAutoConfiguration
public class PropertyBeanUtil {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public PropertyBean propertyBean() {
        return new PropertyBean();
    }

}
