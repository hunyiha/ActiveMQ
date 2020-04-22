package com.example.boot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @program: activemq->ConfigBean
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 09:47
 **/

@Component    //更多的是使用@Configuration注解，而不是@Component
@EnableJms   //开启JMS适配的注解 测试之后 不开启发送消息也没有影响
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }
}
