package org.huangding.zuul.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangding
 * @description
 * @date 2018/9/27 10:35
 */
@Controller
public class TestController {

    @RequestMapping("b")
    public String baidu(){
        return "redirect:https://www.baidu.com/";
    }

}
