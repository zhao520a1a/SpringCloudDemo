package com.example.demo;

import com.example.demo.util.SpringContext;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 赵金鑫
 * @date 2017年09月19日
 */

public class KafkaPropertiesUtil {


    private static KafkaProperties kp = SpringContext.getBean("kafkaProperties");

    /**
     * Get batchSize int number.
     */
    public static int getBatchSize() {
        return kp.getBatchSize();
    }


    /**
     * Get brokers string.
     */
    public static String getBrokers() {
        return kp.getBrokers();
    }


    /**
     * Get zk servers string.
     */
    public static String getZkServers() {
        return kp.getZkServers();
    }

    /**
     * Get default topic string.
     */
    public static String getDefaultTopic() {
        return kp.getDefaultTopic();
    }


    /**
     * 获取处理kafka消息的线程池最大并发线程数量
     * @return
     */
    public static int getNThreads() {
        return kp.getNThreads();
    }


}

@Data
@Component
@ConfigurationProperties(prefix = "kafka")
class KafkaProperties {

    /**
     * kafka的brokers的地址
     */
    private String brokers;

    /**
     * 结果集批量发送大小
     */
    private int batchSize = 1;

    /**
     * ZK的地址
     */
    private String zkServers;

    /**
     *
     */
    private String defaultTopic;

    /**
     * 消费者的线程数；默认为5
     */
    private int nThreads = 5;
}





