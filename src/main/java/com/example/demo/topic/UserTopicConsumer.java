package com.example.demo.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * topic订阅者
 */
public class UserTopicConsumer {

    private static final  String url="tcp://192.168.174.128:61616";

    private static final String topicName="topicText";

    public static  void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
         Destination destination= session.createTopic(topicName);
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(message -> {
            TextMessage textMessage= (TextMessage) message;
            try {
                System.out.println("接收消息"+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

    }
}
