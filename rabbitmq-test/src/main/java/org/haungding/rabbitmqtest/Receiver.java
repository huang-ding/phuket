package org.haungding.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author huangding
 * @description
 * @date 2018/9/27 17:21
 */
@Component
@RabbitListener(queues = "hello1")
public class Receiver {

    @RabbitListener
    public void process(String hello){
        System.out.println("Receiver : " + hello);
    }

}
