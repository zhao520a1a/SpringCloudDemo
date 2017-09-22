# SpringCloudDemo

eureka-server：服务中心
http://localhost:8888

service-zuul：路由转发与过滤
http://localhost:8890/api-a/testRibbon?name=Golden1&token=22
http://localhost:8890/api-b/testFeign?name=Golden1&token=22
测过滤功能:  http://localhost:8890/api-b/testFeign?name=Golden1

service-feign:调用服务
http://localhost:8880/testFeign?name=Golden
service-ribbon:调用服务
http://localhost:8880/testRibbon?name=Golden

eureka-client：服务客户端
http://localhost:8880/testPort?name=Golden

zipkin-server:服务追踪
http://localhost:10000

config-server:配置中心
http://localhost:9999/config-client-dev.properties

config-client:配置客户端
http://localhost:9998/getDataFromConfigServer
