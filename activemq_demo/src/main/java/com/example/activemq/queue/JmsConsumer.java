package com.example.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import java.io.IOException;

import static com.example.activemq.queue.JmsProduce.DEFAULT_BROKER_URL;
import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * @program: activemq->JmsConsumer
 * @description:
 * @author: hunyiha
 * @create: 2020-04-21 13:25
 **/
public class JmsConsumer {

    public static final String DEFAULT_BROKER_URL = "tcp://122.51.83.231:61616";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
        //1.创建连接工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);

        //2.通过连接工厂创建连接并开始连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3.通过连接，创建session会话     两个参数，第一个事务， 第二个签收
        Session session = connection.createSession(false,AUTO_ACKNOWLEDGE);

        //4.创建目的地（队列还是主题） 指定队列的名字  也可以使用Destination接收，Queue这个接口继承自Destination  将生产的东西放到那里
        Queue queue = session.createQueue(QUEUE_NAME);

        //5.创建消费者  参数表示去哪里消费
        MessageConsumer messageConsumer = session.createConsumer(queue);

       /*
          同步阻塞方式reveive()   空参数的receive方法是阻塞，有参数的为等待时间
          订阅者或消费者使用MessageConsumer 的receive() 方法接收消息，receive 在接收之前一直阻塞
          receive这个方法如果不带参数，时间到了就会停止  如果没有参数，则会一直等待，不见不散
        while(true){
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
           if(null != textMessage){
               System.out.println("****消费者接受到的消息：" + textMessage.getText());
           }else{
               break;
           }

        }

        messageConsumer.close();
        session.close();
        connection.close();*/

        // 通过监听的方式来消费消息
        // 通过异步非阻塞的方式消费消息
        // 通过messageConsumer 的setMessageListener 注册一个监听器，
        // 当有消息发送来时，系统自动调用MessageListener 的 onMessage 方法处理消息
       messageConsumer.setMessageListener(new MessageListener() {
           @Override
           public void onMessage(Message message) {
               if(message!=null && message instanceof TextMessage){
                   try {
                       System.out.println("****消费者接受到的消息：" + ((TextMessage) message).getText());
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
           }
       });

       //保证控制台不灭
       System.in.read();
       messageConsumer.close();
       session.close();
       connection.close();
    }
}
