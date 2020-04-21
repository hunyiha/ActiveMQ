package com.example.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @program: activemq->SpringMQ_Consumer
 * @description:
 * @author: hunyiha
 * @create: 2020-04-21 18:06
 **/

@Service
public class SpringMQ_Consumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMQ_Consumer consumer = (SpringMQ_Consumer) app.getBean("springMQ_Consumer");
        String message = (String) consumer.jmsTemplate.receiveAndConvert();

        System.out.println("消费者接收到的消息：" +message);
    }
}
