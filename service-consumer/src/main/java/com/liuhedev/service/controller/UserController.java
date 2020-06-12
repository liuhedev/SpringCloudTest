
package com.liuhedev.service.controller;

import com.liuhedev.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liuhe
 * @date 2020/06/11
 */
@RestController
@RequestMapping("consumer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息

    @GetMapping
    @ResponseBody
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public String queryUserById(@RequestParam("id") Long id) {
        // 1、直接调用服务提供者，硬编码、不好维护；
        //        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);

        //2、使用discoveryClient查询服务提供者
//        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        // 因为只有一个Service-provider。所以获取第一个实例
//        ServiceInstance instance = instances.get(0);
//        // 获取ip和端口信息，拼接成服务地址
//        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;

        //3、使用配置负载均衡的RestTemplate
        String baseUrl = "http://service-provider/user/" + id;
        String user = this.restTemplate.getForObject(baseUrl, String.class);
        return user;
    }

    //    熔断的降级逻辑方法必须跟正常逻辑方法保证：相同的参数列表和返回值声明。
    //    失败逻辑中返回User对象没有太大意义，一般会返回友好提示。所以我们把queryById的方法改造为返回String，反正也是Json数据。这样失败逻辑中返回一个错误说明，会比较方便。
    public String queryUserByIdFallback(Long id) {
        return "请求繁忙，请稍后再试！";
    }
}
