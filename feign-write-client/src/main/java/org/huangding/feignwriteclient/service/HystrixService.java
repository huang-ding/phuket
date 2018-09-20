package org.huangding.feignwriteclient.service;

import org.huangding.feignwriteclient.hystric.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangding
 * @description
 * @date 2018/9/20 10:03
 */
@FeignClient(value = "login-client", fallback = SchedualServiceHiHystric.class)
public interface HystrixService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHi(@RequestParam("name") String name);
}
