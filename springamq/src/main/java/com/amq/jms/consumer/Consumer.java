package com.amq.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/3/9.
 */
public class Consumer {
    public static  void main(String[] args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:consumer.xml");

    }
}
