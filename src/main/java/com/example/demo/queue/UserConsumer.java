package com.example.demo.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 队列消费者
 */
public class UserConsumer {

    private static final String url ="tcp://192.168.174.128:61616";
    private static final String queueName="queueText";

    public static void main(String[] args) throws JMSException {

        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
       Destination destination = session.createQueue(queueName);
        /**
         * 创建接收者从目的地接收消息
         */
        MessageConsumer consumer = session.createConsumer(destination);
        /**
         * 创建一个监听器
         */
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                /**
                 * 根据相应的消息类型进行转换
                 */
                TextMessage textMessage= (TextMessage) message;
                try {
                    System.out.println("接收消息"+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
