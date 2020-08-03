package com.example.demo.custom.cache;

import java.util.concurrent.TimeUnit;

/**
 * 过期缓存检测线程
 *
 * @author liuhe
 * @date 2020/07/31
 */
public class ExpireThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                // 每十秒检测一次
                TimeUnit.SECONDS.sleep(10);
                // 缓存检测和清除的方法
                expireCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void expireCache() {

    }
}
