package org.huangding.redismqregister.controller;

import com.alibaba.fastjson.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.huangding.redismqregister.model.User;
import org.huangding.redismqregister.mq.RabbitmqSender;
import org.huangding.redismqregister.redis.RedisGetMethodInterface;
import org.huangding.redismqregister.redis.RedisUtil;
import org.huangding.redismqregister.service.UserService;
import org.huangding.redismqregister.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 14:31
 */
@RestController
@RequestMapping("test")
@Slf4j
@Api("测试")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitmqSender rabbitmqSender;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("测试")
    @PostMapping("/save")
    public JsonResult save(@RequestParam(value = "name") String name) {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setNameTest(name + i);
            rabbitmqSender.sendSaveUser(user);
        }
        return JsonResult.SUCCESS();
    }

    @ApiOperation("测试")
    @GetMapping("/save/{name}")
    public JsonResult saveMail(@PathVariable String name) {
        User user = new User();
        user.setNameTest(name);
        rabbitmqSender.sendSaveUser(user);
        return JsonResult.SUCCESS();
    }


    @ApiOperation("测试查询")
    @GetMapping("/get")
    public JsonResult get() {
        return JsonResult.DATA(redisUtil.hget("user_test2121", "all1", () -> userService.all(), 10,
            new TypeReference<List<User>>() {
            }));

//        return JsonResult.DATA(redisUtil.hget("user_test", "all", () -> {
//            List<Map<String, Object>> result = new ArrayList<>();
//            Map<String, Object> map = new HashMap<>();
//            map.put("nmd", "nmd");
//            result.add(map);
//            return result;
//        }, User.class));
    }
}
