package org.huangding.redismqregister.service;

import java.util.List;
import org.huangding.redismqregister.base.BaseService;
import org.huangding.redismqregister.dao.User2Dao;
import org.huangding.redismqregister.dao.UserDao;
import org.huangding.redismqregister.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 14:25
 */
@Service
public class UserService implements BaseService<User> {
    @Autowired
    private UserDao userDao;

    @Autowired
    private User2Dao user2Dao;

    @Override
    public Integer save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> all() {
        return user2Dao.getAll();
    }
}
