package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 赵金鑫
 * @date 2017年09月19日
 *
 * 从配置文件读取信息，自动装配成JavaBean
 */

@Configuration
@EnableAutoConfiguration
public class KafkaConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "kafka")
    public KafkaProperties getKafkaProperties() {
        return new KafkaProperties();
    }

}
