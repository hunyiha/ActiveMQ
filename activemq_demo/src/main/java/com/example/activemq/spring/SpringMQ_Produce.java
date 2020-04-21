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
 * @program: activemq->SpringMQ_Produce
 * @description:
 * @author: hunyiha
 * @create: 2020-04-21 18:05
 **/

@Service
public class SpringMQ_Produce {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMQ_Produce produce = (SpringMQ_Produce) app.getBean("springMQ_Produce");
        produce.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("***spring和ActiveMQ的整合case111");
                return textMessage;
            }
        });

        System.out.println("send message over");
    }
}
