# SpringCloudDemo
 
eureka-server：高可用服务的注册与发现（Eureka）  2个服务中心，相互感应，对等关系
http://localhost:8888
http://localhost:8889

service-zuul：路由网关(zuul)-转发与过滤
http://localhost:8890/api-a/testRibbon?name=Golden1&token=22
http://localhost:8890/api-b/testFeign?name=Golden1&token=22
测过滤功能:  http://localhost:8890/api-b/testFeign?name=Golden1

service-feign: 服务消费者（Feign）：断路器（Hystrix）+ 服务链路追踪(zipkin) +  注册服务（Eureka）
http://localhost:8880/testFeign?name=Golden
service-ribbon: 服务消费者（rest+ribbon） ：断路器（Hystrix） + 服务链路追踪(zipkin) +  注册服务（Eureka）
http://localhost:8880/testRibbon?name=Golden

eureka-client：服务客户端  ： 注册服务（Eureka）
http://localhost:8880/testPort?name=Golden

config-server: 分布式配置中心(Spring Cloud Config)  ： 注册服务（Eureka）
http://localhost:9999/config-client-dev.properties

config-client:配置客户端 ： 注册服务（Eureka）
http://localhost:9998/getDataFromConfigServer

zipkin-server:服务链路追踪(Spring Cloud Sleuth)
http://localhost:10000

service-kafka:消息总线(Spring Cloud Bus)
http://localhost:7777/test


