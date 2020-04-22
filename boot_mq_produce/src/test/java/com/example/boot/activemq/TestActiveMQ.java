package com.example.boot.activemq;

import com.example.boot.activemq.consumer.Queue_Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: activemq->TestActiveMQ
 * @description:
 * @author: hunyiha
 * @create: 2020-04-22 10:20
 **/
@SpringBootTest(classes = MainApp_Produce.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {

    @Autowired
    private Queue_Produce queue_produce;

    @Test
    public void testSend(){
        queue_produce.produceMsg();
    }
}
