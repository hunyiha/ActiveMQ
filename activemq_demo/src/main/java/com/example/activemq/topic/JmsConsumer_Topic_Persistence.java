package com.example.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * @program: activemq->JmsConsumer_Topic_Persistence
 * @description:
 * @author: hunyiha
 * @create: 2020-04-21 16:09
 **/
public class JmsConsumer_Topic_Persistence {
    public static final String DEFAULT_BROKER_URL = "tcp://122.51.83.231:61616";
    public static final String TOPIC_NAME = "topic_persistence";

    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("****z3......");

        //1.创建连接工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);

        //2.通过连接工厂创建连接并开始连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("z3");

        //3.通过连接，创建session会话     两个参数，第一个事务， 第二个签收
        Session session = connection.createSession(false,AUTO_ACKNOWLEDGE);

        //4.创建目的地（队列还是主题） 指定主题的名字  也可以使用Destination接收，Topic这个接口继承自Destination  将生产的东西放到那里
        Topic topic = session.createTopic(TOPIC_NAME);

        //4.1订阅者订阅topic主题  第二个参数可以当做一个备注信息
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"remark....");

        connection.start();

        //5.主题订阅者订阅者接收消息  以前是消费者接收消息
        Message message = topicSubscriber.receive();

        while(message != null){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("*****收到的持久化消息：" + textMessage.getText());
            topicSubscriber.receive();
        }

        session.close();
        connection.close();
    }
}
