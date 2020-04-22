package com.example.boot.activemq.topic.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @program: activemq->Topic_Consumer
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 11:48
 **/
@Component
public class Topic_Consumer {

    @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage){
        try {
            System.out.println("消费者收到订阅的主题：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
