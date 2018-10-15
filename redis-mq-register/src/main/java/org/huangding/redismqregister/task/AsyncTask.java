package org.huangding.redismqregister.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author huangding
 * @description
 * @date 2018/9/29 16:04
 */
@Component
@Slf4j
public class AsyncTask {

    @Async("geAsynctExecutor")
    public void Test(int i) throws InterruptedException {
        log.info("--------------{}" + i, "结束了");
    }

}
