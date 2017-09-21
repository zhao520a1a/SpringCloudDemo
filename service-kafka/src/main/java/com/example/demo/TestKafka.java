package com.example.demo;

import com.example.demo.mq.producer.KafkaProducerUtil;
import com.example.demo.vo.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵金鑫
 * @date 2017年09月20日
 */
@Slf4j
@RestController
public class TestKafka {


    @RequestMapping("/test")
    public void testKafka() {
        RequestVO requestVO = RequestVO.builder().jobId("001").header("响应头1").kafkaTopic("topic1").sql("SQL is here!").build();
        KafkaProducerUtil.sendMessage(requestVO);
    }
    @RequestMapping("/testKafkaProperties")
    public void testKafkaProperties() {
        log.info(KafkaPropertiesUtil.getDefaultTopic());
    }
}