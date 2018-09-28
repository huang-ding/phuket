package org.huangding.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @description
 * @date 2018/9/27 11:13
 */
@RestController
public class TestConfig {

    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }


    @Value("${hd}")
    private String hd;


    @RequestMapping(value = "/hd")
    public String hd(){
        return hd;
    }


}
