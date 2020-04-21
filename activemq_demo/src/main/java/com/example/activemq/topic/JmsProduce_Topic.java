package com.example.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * @program: activemq->JmsProduce_Topic
 * @description:
 * @author: hunyiha
 * @create: 2020-04-21 14:06
 **/
public class JmsProduce_Topic {
    public static final String DEFAULT_BROKER_URL = "tcp://122.51.83.231:61616";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {

        //1.创建连接工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);

        //2.通过连接工厂创建连接并开始连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3.通过连接，创建session会话     两个参数，第一个事务， 第二个签收
        Session session = connection.createSession(false,AUTO_ACKNOWLEDGE);

        //4.创建目的地（队列还是主题） 指定队列的名字  也可以使用Destination接收，Topic这个接口继承自Destination  将生产的东西放到那里
        Topic topic = session.createTopic(TOPIC_NAME);

        //5.创建消息的生产者  参数是消息生产后存放的位置 这里使用的是topic
        MessageProducer messageProducer = session.createProducer(topic);

        //6.通过messageProducer将生产的三条消息发送到mq的队列里面
        for (int i = 1; i <=3 ; i++) {
            //7.创建消息，好比学生按照老师的要求写好面试题消息
            TextMessage textMessage = session.createTextMessage("msg---" + i);
            //8.通过messageProducer将生产的消息发送到mq
            messageProducer.send(textMessage);
        }

        //9.关闭资源
        messageProducer.close();
        session.close();
        connection.close();
    }
}
