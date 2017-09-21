package com.example.demo.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring容器上下文工具类
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 获取spring容器上下文
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取容器中的Bean对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanid) {
        return (T) context.getBean(beanid);
    }
}
