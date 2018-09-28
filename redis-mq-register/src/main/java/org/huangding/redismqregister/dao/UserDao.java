package org.huangding.redismqregister.dao;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.huangding.redismqregister.model.User;

public interface UserDao {

    @Select(" select * from user_test")
    @Results({
        @Result(property = "nameTest", column = "name_test")
    })
    List<User> getAll();

    @Insert(" INSERT INTO user_test(name_test) VALUES(#{nameTest})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Integer save(User user);


}
