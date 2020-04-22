package com.example.boot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @program: activemq->Queue_Consumer
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 11:00
 **/

@Component
public class Queue_Consumer {

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("****消费者收到消息：" + textMessage.getText());
    }
}
