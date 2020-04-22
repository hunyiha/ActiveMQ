package com.example.boot.activemq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @program: activemq->Queue_Produce
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 09:48
 **/

@Component
public class Queue_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;  //JmsMessagingTemplate和JmsTemplate功能差不多，但是前一个更加强一些

    @Autowired
    private Queue queue;

    //触发投送     ActiveMQ最经典的投递方式：1.触发投送  2.定时间隔投送
    public void produceMsg(){
        //convertAndSend方法比send方法更加强，可以完成自动转换
        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0,6));
    }

    //ActiveMQ定时间隔投递  3秒钟投递一次
    @Scheduled(fixedDelay = 3000L)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue, "****定时投递" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("produceMsgScheduled send over");
    }
}
