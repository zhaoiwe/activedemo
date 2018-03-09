package com.test.springamq;

import com.amq.jms.producerservice.ProducerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/3/9.
 */
public class AppTest {

    public static void main(String[] args){
        ClassPathXmlApplicationContext  applicationContext=new ClassPathXmlApplicationContext("classpath:producer.xml");
        ProducerService bean = applicationContext.getBean(ProducerService.class);
        for (int i=1;i<=100;i++) {
            bean.setmesage("test"+i);
        }
        applicationContext.close();
    }
}
