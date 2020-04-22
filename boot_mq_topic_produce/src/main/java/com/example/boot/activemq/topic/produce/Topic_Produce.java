package com.example.boot.activemq.topic.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.Queue;
import java.util.UUID;

/**
 * @program: activemq->Topic_Produce
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 11:23
 **/
@Component
public class Topic_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 3000L)
    public void topicProduce(){
        jmsMessagingTemplate.convertAndSend(topic,"主题消息：" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("topicProduce send message over");
    }
}
