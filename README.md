# release v0.0.4
## 说明
该项目是一个Spring cloud学习的简单Demo,详细目录说明如下：
- `config-repo` spring cloud config 远程仓库
- `spring-boot-demo-security` spring-security演示
- `spring-cloud-demo-api-gateway` spring cloud的网关服务
- `spring-cloud-demo-base` 继承的spring boot 和 mybatis的集成
- `spring-cloud-demo-config-client` spring cloud config客户端
- `spring-cloud-demo-config-server` spring cloud config服务端
- `spring-cloud-demo-eureka-client` eureka客户端
- `spring-cloud-demo-eureka-feign` eureka客户端，集成feign
- `spring-cloud-demo-eureka-ribbon` eureka客户端，集成ribbon
- `spring-cloud-demo-eureka-server` eureka服务端

## 运行说明
### 演示服务注册
- 启动eureka服务器
启动`spring-cloud-demo-eureka-server`服务，访问`localhost:8761`，查看`Instances currently registered with Eureka`
- 启动eureka客户端
启动`spring-cloud-demo-eureka-client`服务，再次访问（刷新）`localhost:8761`,再次查看`Instances currently registered with Eureka`

### 演示服务消费
#### ribbon实现负载均衡
- 启动eureka服务
启动`spring-cloud-demo-eureka-server`服务，访问`localhost:8761`，查看`Instances currently registered with Eureka`
- 启动eureka计算客户端
启动`spring-cloud-demo-eureka-client`服务，然后修改该服务端口，再启动一个该服务
- 启动ribbon服务
启动`spring-cloud-demo-eureka-ribbon`服务（端口为8771）
- 测试
访问两次`localhost:88771/add`，可以看到上述两个`spring-cloud-demo-eureka-client`的接口分别被调用
#### feign实现负载均衡
做法如上

### 测试熔断器(Hystrix)
#### ribbon
ribbon中需要手动添加Hystrix依赖
- 启动`spring-cloud-demo-eureka-server`
- 启动`spring-cloud-demo-eureka-client`
- 启动`spring-cloud-demo-eureka-ribbon`
- 访问`localhost:88771/add`可以看到正常的返回值
- 关闭`spring-cloud-demo-eureka-client`服务，访问`localhost:88771/add`可以看到`Hystrix`的处理结果（返回`error`）
#### Feign
feign已经集成Hystrix,测试过程如上

### 测试服务网关（zuul）
- 启动`spring-cloud-demo-eureka-server`
- 启动两个`spring-cloud-demo-eureka-client`，端口分别为8762和8763
- 启动`spring-cloud-demo-eureka-ribbon`
- 启动`spring-cloud-demo-eureka-feign`
- 启动`spring-cloud-demo-api-gateway`
- 访问`http://localhost:8661/api-a-url/add?a=1&b=2&accessToken=123`可以看到端口`8762`的`spring-cloud-demo-eureka-client`
- 访问`http://localhost:8661/api-a/add?a=1&b=2&accessToken=123`可以看到`spring-cloud-demo-eureka-feign`被访问，同时一个`spring-cloud-demo-eureka-client`被访问
- 访问`http://localhost:8661/api-b/add?a=1&b=2&accessToken=123`可以看到`spring-cloud-demo-eureka-ribbon`被访问，同时一个`spring-cloud-demo-eureka-client`被访问

### 测试配置服务
- 启动`spring-cloud-config-server`（端口为8881）
- 启动`spring-cloud-config-client`（端口为8882）
- 访问`http://localhost:8881/didispace/prod`可以直接访问服务端获取配置信息
- 访问`http://localhost:8882/from`，展示了客户端获取某个指定值