package org.huangding.redismqregister.mq;

import com.alibaba.fastjson.JSON;
import org.huangding.redismqregister.model.User;
import org.huangding.redismqregister.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 16:50
 */
@Service
public class RabbitmqReceiver {
    @Autowired
    private UserService userService;



    @RabbitListener(queues = RabbitmqConfig.SAVE_USER)
    public void receiveSaveUser(String message){
        User user = JSON.parseObject(message, User.class);
        userService.save(user);
    }

}
