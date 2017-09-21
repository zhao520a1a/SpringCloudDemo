package com.example.demo;

import com.example.demo.mq.consumer.KafkaConsumerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static java.lang.Boolean.parseBoolean;

@Slf4j
@SpringBootApplication
public class ServiceKafkaApplication {

    public static void main(String[] args) {

        log.info("start FacadeApplication...");
        final ApplicationContext ctx = SpringApplication.run(ServiceKafkaApplication.class, args);
        Environment environment = ctx.getEnvironment();
        if (kafkaEnable(environment)) {
            KafkaConsumerUtil.startup();
        }
    }


    //初始化启动kafka消费者的开关
    private static boolean kafkaEnable(Environment environment) {
        return parseBoolean(environment.getProperty("kafka.enabled", "false"));
    }



}
