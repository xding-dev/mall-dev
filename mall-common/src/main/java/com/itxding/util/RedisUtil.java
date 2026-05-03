package com.itxding.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.concurrent.TimeUnit;


// Redis工具类
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // ==================== 通用操作 ====================

    /**
     * 设置过期时间
     */
    public boolean expire(String key, long time) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, time, TimeUnit.SECONDS));
    }

    /**
     * 判断 key 是否存在
     */
    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 删除 key
     */
    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * 批量删除 key
     */
    public long delete(Collection<String> keys) {
        return redisTemplate.delete(keys);
    }

    // ==================== String 操作 ====================

    /**
     * 获取值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置值（不过期）
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置值（带过期时间）
     */
    public void set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
    }

    /**
     * 原子递增（用于库存扣减）
     */
    public long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 原子递减（用于库存扣减）
     */
    public long decrement(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    // ==================== 分布式锁（简单版） ====================

    /**
     * 尝试获取分布式锁
     * @param key 锁的 key
     * @param value 锁的 value（通常是请求ID，用于释放锁时校验）
     * @param time 锁的过期时间（秒）
     * @return true=获取成功，false=获取失败
     */
    public boolean tryLock(String key, String value, long time) {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key, value, time, TimeUnit.SECONDS));
    }
}
