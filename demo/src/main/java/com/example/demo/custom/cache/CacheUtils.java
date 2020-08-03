package com.example.demo.custom.cache;

import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * 缓存工具类
 *
 * @author liuhe
 * @date 2020/07/31
 */
public class CacheUtils {
    public void put(String key, Object value, long expire) {
        if (StringUtils.isEmpty(key)) {
            return;
        }

        if (CacheGlobal.concurrentHashMap.containsKey(key)) {
            CacheNode cache = CacheGlobal.concurrentHashMap.get(key);
            cache.setHitCount(cache.getHitCount() + 1);
            cache.setWriteTime(System.currentTimeMillis());
            cache.setLastTime(System.currentTimeMillis());
            cache.setExpireTime(expire);
            cache.setValue(value);
            return;
        }

        CacheNode cacheNode = new CacheNode();
        cacheNode.setKey(key);
        cacheNode.setValue(value);
        cacheNode.setWriteTime(System.currentTimeMillis());
        cacheNode.setLastTime(System.currentTimeMillis());
        cacheNode.setHitCount(1);
        cacheNode.setExpireTime(expire);
        CacheGlobal.concurrentHashMap.put(key, cacheNode);
    }

    public Object get(String key) {
        // 非空判断
        if (StringUtils.isEmpty(key)) return null;
        // 字典中不存在
        if (CacheGlobal.concurrentHashMap.isEmpty()) {
            {
                return null;
            }
        }
        if (!CacheGlobal.concurrentHashMap.containsKey(key)) {
            return null;
        }
        CacheNode cache = CacheGlobal.concurrentHashMap.get(key);
        if (cache == null) {
            return null;
        }
        // 惰性删除，判断缓存是否过期
        long timoutTime = System.currentTimeMillis() - cache.getWriteTime();
        // 缓存过期
        if (cache.getExpireTime() <= timoutTime) {
            // 清除过期缓存
            CacheGlobal.concurrentHashMap.remove(key);
            return null;
        }
        cache.setHitCount(cache.getHitCount() + 1);
        cache.setLastTime(System.currentTimeMillis());
        return cache.getValue();
    }
}
