# SpringCloudTest
spring cloud study
Spring Cloud 版本号说明
* Spring Cloud 版本用的是单词而不是数字，为了避免子版本号与子项目版本号混淆。
* 采用伦敦的地铁站名称来作为版本号的命名，根据首字母排序，字母顺序靠后的版本号 越大。



@RequestMapping 是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径；用于方法上，表示在类的父路径下追加方法上注解中的地址将会访问到该方法。例如.
@Responsebody注解表示该方法的返回的结果直接写入 HTTP 响应正文中，一般在异步获取数据时使用；
在使用@RequestMapping后，返回值通常解析为跳转路径，加上@Responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中。例如，异步获取json数据，加上@Responsebody注解后，就会直接返回json数据。
@RequestBody注解则是将 HTTP 求正文插入方法中，使用适合的HttpMessageConverter将请求体写入某个对象。


## 熔断状态机3个状态：
- Closed：关闭状态，所有请求都正常访问。
- Open：打开状态，所有请求都会被降级。Hystix会对请求情况计数，当一定时间内失败请求百分比达到阈值，则触发熔断，断路器会完全打开。默认失败比例的阈值是50%，请求次数最少不低于20次。
- Half Open：半开状态，open状态不是永久的，打开后会进入休眠时间（默认是5S）。随后断路器会自动进入半开状态。此时会释放部分请求通过，若这些请求都是健康的，则会完全关闭断路器，否则继续保持打开，再次进行休眠计时


1. @EnableDiscoveryClient 注解是基于 spring-cloud-commons 依赖，并且在classpath中实现； 
2. @EnableEurekaClient 注解是基于 spring-cloud-netflix 依赖，只能为eureka作用；


# Zuul
## 过滤器
  - 请求鉴权：一般放在pre类型，如果发现没有访问权限，直接就拦截了
  - 异常处理：一般会在error类型和post类型过滤器中结合来处理。
  - 服务调用时长统计：pre和post结合使用。

[jdbc根据mysql版本不同，驱动不同](https://blog.csdn.net/superdangbo/article/details/78732700)
`spring:
  application:
    name: service-provider # 应用名称，注册到eureka后的服务名称
  datasource:
    url: jdbc:mysql://localhost:3306/students?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    username: root
    password: root
    # 不加此配置driver-class-name，会报错Failed to configure a DataSource: no embedded datasource could be configured
    #    1、JDBC连接Mysql5 com.mysql.jdbc.Driver:
    #    2、JDBC连接Mysql6 com.mysql.cj.jdbc.Driver， 需要指定时区serverTimezone:
    driver-class-name: com.mysql.jdbc.Driver
`

[理解spring-boot-starter-parent](https://www.jianshu.com/p/628acadbe3d8)
