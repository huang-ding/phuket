package org.huangding.redismqregister.mq;

import com.alibaba.fastjson.JSON;
import org.huangding.redismqregister.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 16:51
 */
@Service
public class RabbitmqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void sendSaveUser(User user) {
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.SAVE_USER, JSON.toJSONString(user));
    }
}
