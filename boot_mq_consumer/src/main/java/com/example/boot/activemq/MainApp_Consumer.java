package com.example.boot.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: activemq->MainApp_Consumer
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 09:49
 **/

@SpringBootApplication
public class MainApp_Consumer {
    public static void main(String[] args) {
        SpringApplication.run(MainApp_Consumer.class,args);
    }
}
