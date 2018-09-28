package org.haungding.rabbitmqtest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangding
 * @description
 * @date 2018/9/27 17:12
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello1");
    }

}
