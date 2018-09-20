package org.huangding.feignwriteclient.hystric;

import org.huangding.feignwriteclient.service.HystrixService;
import org.springframework.stereotype.Component;

/**
 * @author huangding
 * @description
 * @date 2018/9/20 10:04
 */
@Component
public class SchedualServiceHiHystric implements HystrixService {

    @Override
    public String sayHi(String name) {
        return "sorry "+name;
    }
}
