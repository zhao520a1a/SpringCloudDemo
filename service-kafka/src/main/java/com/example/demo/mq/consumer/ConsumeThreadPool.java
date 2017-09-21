package com.example.demo.mq.consumer;

import com.example.demo.KafkaPropertiesUtil;
import lombok.Builder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 处理kafka消息的线程池
 *
 */
public class ConsumeThreadPool {
    private static ExecutorService es = Executors.newFixedThreadPool(KafkaPropertiesUtil.getNThreads());

    /**
     * 向线程池中添加线程
     *
     * @param msg kafka消息
     */
    public static void putThread(String msg) {
        es.execute(ConsumeThread.builder().msg(msg).build());
    }


}


@Builder
class ConsumeThread implements Runnable {
    private String msg;

    @Override
    public void run() {
        KafkaConsumerUtil.consumeMsg(msg);
    }

}


