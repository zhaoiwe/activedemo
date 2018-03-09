package com.example.demo.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 主题订阅方式发送者
 * @author zw
 */
public class UserProducer {

    private static final String url="tcp://192.168.174.128:61616";
    private static final String topicName="topicText";


    public static void main(String[] args) throws JMSException {

        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        /**
         * 创建topic方式 目的地
         *
         */
         Destination destination = session.createTopic(topicName);
        MessageProducer producer = session.createProducer(destination);
        for (int i=1;i<=100;i++){
            TextMessage textMessage= session.createTextMessage("test"+i);
            producer.send(textMessage);
            System.out.println("发送消息"+i+"次"+textMessage.getText());
        }
        connection.close();
    }

}
