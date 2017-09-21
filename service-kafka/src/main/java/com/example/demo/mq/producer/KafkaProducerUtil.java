package com.example.demo.mq.producer;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.KafkaPropertiesUtil;
import com.example.demo.util.StringUtil;
import com.example.demo.vo.RequestVO;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author 赵金鑫
 * @date 2017年09月19日
 */

public class KafkaProducerUtil {

    private static Producer<String, String> producer ;



    static {
        if (producer == null) {
            Properties props = new Properties();
            props.put("bootstrap.servers", KafkaPropertiesUtil.getBrokers());
            props.put("acks", "all");
            props.put("retries", 0);
            props.put("batch.size", KafkaPropertiesUtil.getBatchSize());
            props.put("linger.ms", 1);
            props.put("buffer.memory", 335544320);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            producer = new KafkaProducer<String, String>(props);
        }
    }


    public static void sendMessage(RequestVO requestVo ) {
        producer.send(new ProducerRecord<String, String>(requestVo.getKafkaTopic(),requestVo.getJobId(), StringUtil.isEmpty(requestVo.getHeader(), new String(new byte[]{0})) + JSONObject.toJSONString(requestVo.toString())));
    }



}
