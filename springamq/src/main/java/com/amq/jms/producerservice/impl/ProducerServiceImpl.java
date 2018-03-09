package com.amq.jms.producerservice.impl;

import com.amq.jms.producerservice.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;
    /**
     * 可能注入多个目的地用resource
     */
    @Resource(name="queueDestination")
    Destination destination;

    @Override
    public void setmesage( final  String mesage) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(mesage);

                return textMessage;
            }
        });
        System.out.println("发送信息"+mesage);
    }
}
