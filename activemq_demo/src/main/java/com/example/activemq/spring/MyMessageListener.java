package com.example.activemq.spring;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @program: activemq->MyMessageListener
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 02:08
 **/

@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if(message != null && message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("消费者接收到的消息：" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
