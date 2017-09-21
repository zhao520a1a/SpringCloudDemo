package com.example.demo.mq.consumer;

import com.example.demo.KafkaPropertiesUtil;
import com.example.demo.util.StringUtil;
import com.example.demo.vo.QueryVO;
import com.example.demo.vo.ResponseVO;
import kafka.consumer.ConsumerConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;


/**
 * The type Kafka consumer util.
 */
@Slf4j
public class KafkaConsumerUtil {


    private static ConsumerConfig createConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaPropertiesUtil.getZkServers() );
        props.put("group.id", "testConsumer");
        props.put("zookeeper.session.timeout.ms", "40000");
        props.put("zookeeper.sync.time.ms", "500");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        return new ConsumerConfig(props);
    }

    /**
     * 启动consumer
     */
    public static void startup() {
        log.info("start kafka consumer  consume topic " + KafkaPropertiesUtil.getDefaultTopic() + "...");
        KafkaConsumerThread consumerThread = new KafkaConsumerThread(createConsumerConfig(), KafkaPropertiesUtil.getDefaultTopic());
        consumerThread.start();
    }




    /**
     * 消费处理kafka的数据
     *
     * @return the response vo
     */
    public static ResponseVO consumeMsg(String msg) {
        log.info("处理kafka的数据:" + msg);
        String header = "";
        int index = msg.indexOf("{");
        if (index > 0) {
            msg = msg.substring(index);
            header = new String(new byte[]{0});
        }

        QueryVO qv = null;
        try {
            //qv = JSONObject.parseObject(msg, QueryVO.class);    解析JSON格式的数据
        } catch (Exception e) {
            //要考虑处理失败的信息该怎么存储然后补发
            log.error(StringUtil.getTrace(e));
            return ResponseVO.builder().success(false).errorMsg(e.getMessage()).build();
        }

        log.info("kafkaTopic is " + qv.getKafkaTopic());
        return ResponseVO.builder().success(true).build();

    }
}
