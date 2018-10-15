package org.huangding.redismqregister.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huangding
 * @description
 * @date 2018/9/29 14:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void leftPush(){
        redisUtil.leftPush("nmd","1","2","3");
    }

    @Test
    public void rightPop(){
        while (true){
            String nmd = redisUtil.rightPop("nmd");
            if(nmd !=null){
                log.info("》》》》》》》》》》》》》{}，", nmd);
            } else {
                break;
            }
        }
        log.info("》》》》》》》》》》》》》终于TMD吗，，，，，，");
    }

}
