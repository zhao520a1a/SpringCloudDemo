package com.example.demo.mq.consumer;

import com.example.demo.util.StringUtil;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Kafka consumer.
 */
@Slf4j
public class KafkaConsumerThread extends Thread {

    private final ConsumerConnector consumer;
    private final String topic;


    public KafkaConsumerThread(ConsumerConfig consumerConfig, String topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);
        consumer.commitOffsets();
        this.topic = topic;
    }

    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        // 获取stream
        Map<String, List<KafkaStream<byte[], byte[]>>> streamsMap = consumer.createMessageStreams(topicCountMap);
        // 为每个stream启动一个线程消费消息
        List<KafkaStream<byte[], byte[]>> streams = streamsMap.get(topic);
        for (final KafkaStream<byte[], byte[]> stream : streams) {
            for (MessageAndMetadata<byte[], byte[]> messageAndMetadata : stream) {
                String msg = null;
                try {
                    msg = new String(messageAndMetadata.message(), "utf-8");
                } catch (Exception e) {
                    log.error(StringUtil.getTrace(e));
                }
                if (!StringUtils.isEmpty(msg)) {
                    ConsumeThreadPool.putThread(msg); // 添加一个消费线程
                }
            }
        }
    }

}
