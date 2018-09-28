package org.haungding.rabbitmqtest;

import java.time.LocalDate;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huangding
 * @description
 * @date 2018/9/27 17:25
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Integer i) {
        String context = "hello " + LocalDate.now().toString()+"--------------------"+i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello1",context);
    }

    public void send(String i) {
        String context = "hello " + LocalDate.now().toString()+"--------------------"+i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello1",context);
    }

}
