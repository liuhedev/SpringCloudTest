package com.example.demo;

import com.google.common.cache.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liuhe
 * @date 2020/07/30
 */
public class GuavaExample {
    public static void main(String[] args) throws ExecutionException {
        // 创建方式1：LoadingCache
//        LoadingCache<String, String> loadCache = CacheBuilder.newBuilder()
//                // 并发级别设置为5，表示可以同时写缓存的线程数
//                .concurrencyLevel(5)
//                // 设置8s过期
//                .expireAfterWrite(2, TimeUnit.SECONDS)
//                // 设置缓存容器的初始化容量为10
//                .initialCapacity(10)
//                // 设置缓存最大容量为100，超过之后会按照LRU算法，移除缓存项
//                .maximumSize(100)
//                //设置要统计缓存的命中率
//                .recordStats()
//                // 设置缓存的移除通知
//                .removalListener(new RemovalListener<Object, Object>() {
//                    @Override
//                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
//                        System.out.println(removalNotification.getKey() + " remove~~~" + removalNotification.getCause());
//                    }
//                })
//                // 指定CacheLoader,缓存不存在时，可自动加载缓存
//                .build(new CacheLoader<String, String>() {
//                    @Override
//                    public String load(String key) throws Exception {
//                        // 自动加载缓存的业务
//                        return "cache-value:" + key;
//                    }
//                });
//        loadCache.put("c1","hello,c1");
//        String c1 = loadCache.get("c1");
//        System.out.println(c1);
//
//        String noval = loadCache.get("noval");
//        System.out.println(noval);
        cache();

    }

private static void cache() throws ExecutionException {
    // 创建方式二：Callable
    Cache<String, String> cache = CacheBuilder.newBuilder()
            .initialCapacity(5) //设置初始容量
            .maximumSize(100) // 设置缓存最大长度
            .build();
    // 设置缓存
    cache.put("k1", "Hello, k1.");
    // 查询缓存
    System.out.println(cache.size());
    String value = cache.get("k2", new Callable<String>() {
        @Override
        public String call() {
            // 缓存不存在时，执行
            return "nil";
        }
    });
    // 输出缓存值
    System.out.println(value);
}
}
