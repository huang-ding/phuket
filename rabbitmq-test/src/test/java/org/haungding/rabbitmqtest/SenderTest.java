package org.haungding.rabbitmqtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huangding
 * @description
 * @date 2018/9/27 17:26
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SenderTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception{
        for(int i=0;i<100;i++){
            sender.send(i);
        }

        for (int i =0;i<100;i++){
            sender.send("i"+i);
        }
    }

}
