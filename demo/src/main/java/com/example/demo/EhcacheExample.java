package com.example.demo;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.HashMap;

/**
 * @author liuhe
 * @date 2020/07/30
 */
public class EhcacheExample {
    public static void main(String[] args) {
        // 创建缓存管理器
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        // 初始化Ehcache
        cacheManager.init();
        // 创建缓存存储器
        Cache<String, String> liuheCache = cacheManager.createCache("liuheCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        String.class, String.class,
                        ResourcePoolsBuilder.heap(10) // 设置缓存最大容量
                ));
        // 设置缓存
        liuheCache.put("key", "hello~~ehcache");
        // 读取缓存
        String value = liuheCache.get("key");
        System.out.println(value);
        // 关闭缓存
        cacheManager.close();
    }
}
