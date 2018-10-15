package org.huangding.redismqregister.task;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huangding
 * @description
 * @date 2018/9/29 16:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void taskTest() throws InterruptedException {
        log.info("--------------》{}", "开始了");
        for(int i=0;i<100;i++){
            asyncTask.Test(i);
        }
    }

}
