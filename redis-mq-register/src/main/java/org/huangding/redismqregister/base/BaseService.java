package org.huangding.redismqregister.base;

import java.util.List;

/**
 * @author huangding
 * @description
 * @date 2018/9/28 14:26
 */
public interface BaseService<T> {

    Integer save(T t);

    List<T> all();
}
