package com.example.activemq.embed;

import org.apache.activemq.broker.BrokerService;

/**
 * @program: activemq->EmbedBroker
 * @description:内嵌的activemq
 * @author: hunyiha
 * @create: 2020-04-21 17:38
 **/
public class EmbedBroker {

    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
