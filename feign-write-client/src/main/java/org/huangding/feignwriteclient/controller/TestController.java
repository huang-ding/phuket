package org.huangding.feignwriteclient.controller;

import org.huangding.feignwriteclient.service.HystrixService;
import org.huangding.feignwriteclient.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @description
 * @date 2018/9/19 17:00
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private HystrixService hystrixService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return testService.sayHi(name);
    }

    @GetMapping(value = "/hi2")
    public String sayHi2(@RequestParam String name) {
        return hystrixService.sayHi(name);
    }
}
