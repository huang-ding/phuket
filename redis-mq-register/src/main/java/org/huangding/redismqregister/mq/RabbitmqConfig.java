package org.huangding.redismqregister.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 16:39
 */
@Configuration
public class RabbitmqConfig {


    public static final String SAVE_USER = "save.user";

    /**
     * 消息队列
     */
    @Bean
    public MessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue saveUser() {
        return new Queue(SAVE_USER, true);
    }
}
