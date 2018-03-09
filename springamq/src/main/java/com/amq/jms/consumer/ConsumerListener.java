package com.amq.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ConsumerListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage= (TextMessage) message;
        try {
            System.out.println("接收的信息:"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
