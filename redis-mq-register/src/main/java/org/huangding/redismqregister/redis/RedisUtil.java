package org.huangding.redismqregister.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author huangding
 * @description
 * @date 2018/9/29 9:08
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key 键
     * @param time 时间(秒) time>0
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     */
    public boolean isKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }


    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 获取对应key的数据 没有按照规则插入
     */
    public <T> T get(String key, RedisGetMethodInterface redisGetMethodInterface,
        long time, Class<T> type) {
        String data = redisTemplate.opsForValue().get(key);
        if (Strings.isNullOrEmpty(data)) {
            if (redisGetMethodInterface != null) {
                data = (String) redisGetMethodInterface.method();
                if (time > 0) {
                    redisTemplate.opsForValue().set(key, data, time);
                } else {
                    redisTemplate.opsForValue().set(key, data);
                }
            } else {
                return null;
            }

        }
        return JSON.parseObject(data, type);
    }


    /**
     * 向一张hash表中取数据
     */
    public <T> T hget(String key, String item,Class<T> type) {
        return hget(key, item, null, 0,type);
    }

    /**
     * 向一张hash表中取数据,如果不存在按照规则创建
     */
    public <T> T hget(String key, String item, RedisGetMethodInterface redisGetMethodInterface,
        Class<T> type) {
        return hget(key, item, redisGetMethodInterface, 0, type);
    }

    /**
     * 向一张hash表中取数据,如果不存在按照规则创建
     *
     * @param redisGetMethodInterface 规则
     * @param time 超时时间
     */
    public <T> T hget(String key, String item, RedisGetMethodInterface redisGetMethodInterface,
        long time, Class<T> type) {
        String data = (String) redisTemplate.opsForHash().get(key, item);
        if (!Strings.isNullOrEmpty(data)) {
            return JSON.parseObject(data, type);
        }
        if (redisGetMethodInterface != null) {
            return redisGetMethodInterfaceData(redisGetMethodInterface,key,item,time);
        }
        return null;
    }

    public <T> T hget(String key, String item, RedisGetMethodInterface redisGetMethodInterface,
        long time, TypeReference<T> typeReference) {
        String data = (String) redisTemplate.opsForHash().get(key, item);
        if (!Strings.isNullOrEmpty(data)) {
            return JSON.parseObject(data, typeReference);
        }
        if (redisGetMethodInterface != null) {
            return redisGetMethodInterfaceData(redisGetMethodInterface,key,item,time);
        }
        return null;
    }

    private <T> T redisGetMethodInterfaceData(RedisGetMethodInterface redisGetMethodInterface,
        String key, String item, long time) {
        T t = (T) redisGetMethodInterface.method();
        redisTemplate.opsForHash().put(key, item, JSON.toJSONString(t));
        if (time > 0) {
            expire(key, time);
        }
        return t;
    }

    public void hset(String key, String item, Object value) {
        hset(key, item, value, 0);
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     */
    public void hset(String key, String item, Object value, long time) {
        redisTemplate.opsForHash().put(key, item, value);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从左边插入）
     */
    public Long leftPush(String key, String... value) {
        if (value != null && value.length > 0) {
            if (value.length == 1) {
                return redisTemplate.opsForList().leftPush(key, value[0]);
            }
            redisTemplate.opsForList().leftPushAll(key, value);
        }
        return null;
    }

    public String leftPop(String key) {
        return leftPop(key, 0);
    }

    /**
     * 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     *
     * @param timeout 阻塞时间（秒）
     */
    public String leftPop(String key, long timeout) {
        if (timeout > 0) {
            return redisTemplate.opsForList().leftPop(key, timeout, TimeUnit.SECONDS);
        }
        return redisTemplate.opsForList().leftPop(key);
    }


    /**
     * 将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从右边插入）
     */
    public Long rightPush(String key, String... value) {
        if (value != null && value.length > 0) {
            if (value.length == 1) {
                return redisTemplate.opsForList().rightPush(key, value[0]);
            }
            redisTemplate.opsForList().rightPushAll(key, value);
        }
        return null;
    }

    public String rightPop(String key) {
        return rightPop(key, 0);
    }

    /**
     * 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     *
     * @param timeout 阻塞时间（秒）
     */
    public String rightPop(String key, long timeout) {
        if (timeout > 0) {
            return redisTemplate.opsForList().rightPop(key, timeout, TimeUnit.SECONDS);
        }
        return redisTemplate.opsForList().rightPop(key);
    }








}
