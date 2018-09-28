package org.huangding.redismqregister.dao;

import com.alibaba.fastjson.JSON;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.huangding.redismqregister.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private User2Dao user2Dao;

    @Test
    public void saveTest(){
        throw new DuplicateKeyException("asdad");
//        User user = new User();

//        user.setNameTest("huangding");
//        Integer save = userDao.save(user);
//        Assert.assertEquals(true,save>0);
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>>saveTest"+save);
//        log.info(">>>>>>>>>>>>>"+ JSON.toJSONString(user));
    }

    @Test
    public void save2Test(){
        User user = new User();
        user.setNameTest("testst");
        Integer save = user2Dao.save(user);
        Assert.assertEquals(true,save>0);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>1111"+save);
        log.info(">>>>>>>>>>>>>"+ JSON.toJSONString(user));

    }

    @Test
    public void select2Test(){
        List<User> all = user2Dao.getAll();
        Assert.assertEquals(true,all.size()>0);
        log.error(">>>>>>>>>>>>>"+ JSON.toJSONString(all));
    }

}
