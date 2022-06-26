# douyin4j

## 该项目主要基于抖音客户端API文档进行开发，考虑从单体式架构转向微服务架构

### 项目技术栈

1. SpringBoot完成每个微服务的开发
2. Eureka完成微服务注册与发现
3. Zuul作为整个服务的入口与网关
4. SpringCloud Config完成远端微服务配置
5. Openfeign完成基于Ribbon的负载均衡和服务间的http调用
6. Hystrix完成服务的熔断、降级、 限流
7. dashboard完成基于hystrix的流量监测
8. Mysql作为数据库
9. Redis作为缓存中间件

### 项目结构

该次项目已经在之前的开发中完成了基于Go和Java的开发，代码存放在douyin4go和douyin4j两个仓库中，可以自行移步观看，由于开发中发现：

涉及到的接口主要分为三大类五小类——用户、视频、评论、点赞、关注，因此采用微服务架构结构较为清晰，分别为这五大服务提供者，基于之前的单体式结构，考虑使用zuul、eureka、config完成分布式设计

### 文件说明

1. Eureka为服务注册中心，本项目使用两个eureka构建集群
2. Zuul为网关，将入口请求分发到各个服务提供者
3. config-server为云配置的服务器
4. provider为五大服务应用
5. dashboard负责流量监控
6. pom.xml控制整个项目的依赖版本
7. commons规定了常用的POJO和Dto类以及工具类和公用的依赖
8. 所有的云配置寄存在Gitee中

## 待补充功能

1. log
2. 分布式事务、锁设计

