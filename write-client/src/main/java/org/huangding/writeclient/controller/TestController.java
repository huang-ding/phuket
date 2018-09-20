package org.huangding.writeclient.controller;

import org.huangding.writeclient.service.HystrixService;
import org.huangding.writeclient.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @description
 * @date 2018/9/19 15:40
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name){
        return testService.hiService(name);
    }

    @GetMapping("/hi2")
    public String hi2(@RequestParam String name){
        return hystrixService.hiService(name);
    }
}
