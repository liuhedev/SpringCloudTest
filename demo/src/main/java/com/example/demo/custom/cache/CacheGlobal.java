package com.example.demo.custom.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache 全局类
 *
 * @author liuhe
 * @date 2020/07/31
 */
public class CacheGlobal {
    public static ConcurrentHashMap<String, CacheNode> concurrentHashMap = new ConcurrentHashMap<>();
}
