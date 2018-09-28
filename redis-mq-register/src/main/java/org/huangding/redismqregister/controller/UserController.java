package org.huangding.redismqregister.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.huangding.redismqregister.model.User;
import org.huangding.redismqregister.service.UserService;
import org.huangding.redismqregister.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation("测试")
    @PostMapping("/save")
    public JsonResult save(@RequestParam(value = "name") String name) {
        User user = new User();
        user.setNameTest(name);
        userService.save(user);
        return JsonResult.DATA(user);
    }
}
