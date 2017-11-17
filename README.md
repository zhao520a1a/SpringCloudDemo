# SpringCloudDemo

consul-miya：它是一个提供服务发现和配置的工具（Consul）   
http://localhost:8500
 
eureka-server：高可用服务的注册与发现（Eureka）  2个服务中心，相互感应，对等关系
http://localhost:8888
http://localhost:8889

service-zuul：路由网关(zuul)-转发与过滤
http://localhost:8890/api-a/testRibbon?name=Golden1&token=22
http://localhost:8890/api-b/testFeign?name=Golden1&token=22
测过滤功能:  http://localhost:8890/api-b/testFeign?name=Golden1

service-feign: 服务消费者（Feign）：断路器（Hystrix + Hystrix Dashboard）+ 服务链路追踪(zipkin) +  注册服务（Eureka）
http://localhost:8881/testFeign?name=Golden
service-ribbon: 服务消费者（rest+ribbon） ：断路器（Hystrix + Hystrix Dashboard） + 服务链路追踪(zipkin) +  注册服务（Eureka）
http://localhost:8880/testRibbon?name=Golden
Hystrix Dashboard：http://localhost:8880/hystrix  ==》  http://localhost:8880/hystrix.stream
 


eureka-client：服务客户端  ： 注册服务（Eureka）
http://localhost:8801/testPort?name=Golden

config-server: 分布式配置中心(Spring Cloud Config)  ： 注册服务（Eureka）
http://localhost:9999/config-client-dev.properties

config-client:配置客户端 ： 注册服务（Eureka）
http://localhost:9998/getDataFromConfigServer

zipkin-server:服务链路追踪(Spring Cloud Sleuth)
http://localhost:10000

service-turbine: 聚合监控(Hystrix Turbine) 将每个服务Hystrix Dashboard数据进行了整合 
http://localhost:8880/hystrix  ==》  http://localhost:11111/turbine.stream
注：
打开监控服务的服务网页http://IP:service_port/hystrix后，输入监控流http://IP:turbine_port/turbine.stream,能看到聚合监控的页面
查看、下载Hystrix流中的数据：http://IP:turbine_port/turbine.stream

service-kafka:消息总线(Spring Cloud Bus)
http://localhost:7777/test


