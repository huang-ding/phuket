package org.huangding.writeclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangding
 * @description
 * @date 2018/9/19 16:36
 */
@Service
public class TestService {
    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name){
        return restTemplate.getForObject("http://LOGIN-CLIENT/hi?name="+name,String.class);
    }

}
