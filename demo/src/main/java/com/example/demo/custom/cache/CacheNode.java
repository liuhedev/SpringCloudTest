package com.example.demo.custom.cache;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liuhe
 * @date 2020/07/31
 */
@Setter
@Getter
public class CacheNode implements Comparable<CacheNode> {
    // 缓存键
    private Object key;
    //缓存值
    private Object value;
    // 创建时间
    private Long writeTime;
    // 最后访问时间
    private long lastTime;
    // 存活时间
    private Long expireTime;
    // 命中次数
    private Integer hitCount;

    @Override
    public int compareTo(CacheNode o) {
        // 比较此对象与指定对象的顺序，如果改对象小于、等于或者大于指定对象，则返回负整数、零或者正整数。
        return hitCount.compareTo(o.hitCount);
    }
}
