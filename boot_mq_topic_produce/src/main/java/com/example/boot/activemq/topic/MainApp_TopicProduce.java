package com.example.boot.activemq.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: activemq->MainApp_TopicProduce
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 11:24
 **/
@SpringBootApplication
@EnableScheduling
public class MainApp_TopicProduce {
    public static void main(String[] args) {
        SpringApplication.run(MainApp_TopicProduce.class,args);
    }
}
