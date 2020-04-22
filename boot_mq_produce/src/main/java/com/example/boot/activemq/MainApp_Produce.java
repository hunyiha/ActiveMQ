package com.example.boot.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @program: activemq->MainApp_Produce
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 09:49
 **/

@SpringBootApplication
@EnableScheduling //开启Scheduled注解   对于SpringBoot的注解 1.首先有没有注解   2.是否激活该注解
public class MainApp_Produce {
    public static void main(String[] args) {
        SpringApplication.run(MainApp_Produce.class,args);
    }
}
