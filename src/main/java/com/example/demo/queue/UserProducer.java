package com.example.demo.queue;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;

/**
 * 消息发布者
 */

public class UserProducer {
    /**
     * 连接地址,61616amq默认端口
     */
    private static final String url="tcp://192.168.174.128:61616";
    /**
     * 消息的名称
     */
    private static final String queueName="queueText";

    public static void main(String[] args) throws JMSException {
        /**
         * 创建连接工厂
         */
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);

        /**
         * 创建连接
         */
        Connection connection= connectionFactory.createConnection();

        /**
         * 启动连接
         */
        connection.start();

        /**
         * 创建会话
         * false:不启用事物
         * Session.AUTO_ACKNOWLEDGE：接收后自动应答
         */
      Session session=  connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        /**
         * 创建一个目标队列
         */
      Destination destination= session.createQueue(queueName);

        /**
         * 创建生产者,向目的地发送消息
         */
        MessageProducer producer = session.createProducer(destination);

        /**
         * 循环发送100次消息
         */
        for (int i=1;i<=100;i++){
            /**
             * 创建消息
             */
            TextMessage textMessage=session.createTextMessage("test"+i);
            /**
             * 发布消息
             */
            producer.send(textMessage);
            System.out.println("第"+i+"消息发送成功"+textMessage.getText());
        }
        /**
         * 关闭连接
         */
        connection.close();
    }

}
