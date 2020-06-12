package com.liuhedev.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuhe
 * @date 2020/06/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceConsumerApp.class)
public class LoadBalanceTest {

    @Autowired
    private RibbonLoadBalancerClient client;

    //    Ribbon默认的负载均衡策略是简单的轮询，可以在application.yml配置负载均衡策略，轮询或者随机
//    service-provider:
//    ribbon:
//    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule或者com.netflix.loadbalancer.RoundRobinRule
//    格式是：{服务名称}.ribbon.NFLoadBalancerRuleClassName，值就是IRule的实现类。

    @Test
    public void testLoadBalance() {
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = this.client.choose("service-provider");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}
