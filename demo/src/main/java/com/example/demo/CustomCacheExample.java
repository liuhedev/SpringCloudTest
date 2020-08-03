package com.example.demo;

import com.example.demo.custom.cache.CacheUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author liuhe
 * @date 2020/07/31
 */
public class CustomCacheExample {
    public static void main(String[] args) {
        CacheUtils cacheUtils = new CacheUtils();

        cacheUtils.put("liuhe","niubi",2*1000);

        Object liuhe = cacheUtils.get("liuhe");
        System.out.println(liuhe);


        try {
            Thread.sleep(3*1000);

            System.out.println(cacheUtils.get("liuhe"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
