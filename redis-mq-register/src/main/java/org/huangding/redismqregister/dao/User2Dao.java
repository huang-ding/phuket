package org.huangding.redismqregister.dao;

import java.util.List;
import org.huangding.redismqregister.model.User;

public interface User2Dao {

    List<User> getAll();

    Integer save(User user);

}
