
#### 官网学习
https://cloud.springEurekaJacksonCodec$DataCenterInfoDeserializer.io/spring-cloud-static/spring-cloud-netflix/2.2.1.RELEASE/reference/html/

#### Eureka 注册中心搭建(集群)
- 导入依赖  
**导入依赖时注意下springcloud 和 springboot 的版本对应关系** 可以在[官网](https://spring.io/projects/spring-cloud#learn)找到相关信息  
![](https://github.com/hutaoying/springcloud-learn/blob/master/springcloud-eureka/.README_images/%E7%89%88%E6%9C%AC%E5%AF%B9%E5%BA%94%E5%85%B3%E7%B3%BB.png)  
假设选springcloud 的Hoxton SR3版本，  
![](https://github.com/hutaoying/springcloud-learn/blob/master/springcloud-eureka/.README_images/f1aedd47.png)
springboot 可使用2.2.5.RELEASE版本  
![](https://github.com/hutaoying/springcloud-learn/blob/master/springcloud-eureka/.README_images/8cc69afe.png)

```
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <!-- springcloud 和springboot版本 需对应-->
                <version>Hoxton.SR3</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

```
- 配置文件
```
server:
  port: 8000
spring:
  application:
    name: spring-cloud-eureka
eureka:
  client:
    register-with-eureka: false # the default is true
    fetch-registry: false # This client gets the registration information on the eureka server registry, the default is true
    #注册中心路径，如果有多个eureka server，在这里需要配置其他eureka server的地址，
    #用","进行区分，如"http://address:8888/eureka,http://address:8887/eureka"
    service-url:
      defaultZone: http://localhost:8001/eureka/,http://localhost:8002/eureka/
  instance:
    # ip-address: 127.0.0.1
    hostname: port1
----

server:
  port: 8001
spring:
  application:
    name: spring-cloud-eureka
eureka:
  client:
    register-with-eureka: false # the default is true
    fetch-registry: false # This client gets the registration information on the eureka server registry, the default is true
    #注册中心路径，如果有多个eureka server，在这里需要配置其他eureka server的地址，
    #用","进行区分，如"http://address:8888/eureka,http://address:8887/eureka"
    service-url:
      defaultZone: http://localhost:8000/eureka/,http://localhost:8002/eureka/
  instance:
    # ip-address: 127.0.0.1
    hostname: port2

------
server:
  port: 8002
spring:
  application:
    name: spring-cloud-eureka
eureka:
  client:
    register-with-eureka: false # the default is true
    fetch-registry: false # This client gets the registration information on the eureka server registry, the default is true
    #注册中心路径，如果有多个eureka server，在这里需要配置其他eureka server的地址，
    #用","进行区分，如"http://address:8888/eureka,http://address:8887/eureka"
    service-url:
      defaultZone: http://localhost:8000/eureka/,http://localhost:8001/eureka/
  instance:
    # ip-address: 127.0.0.1
    hostname: port3

```
需要在hosts文件配置  hostname和ip 的对应关系（实际请求会根据hosts文件中的配置进行域名解析，可以了解下hosts文件[Linux 下hosts文件详解](https://www.cnblogs.com/quanjq/p/7737475.html)）

- 启动类  
![](https://github.com/hutaoying/springcloud-learn/blob/master/springcloud-eureka/.README_images/7ef0c14d.png)

- 启动
用 IDEA maven 打个包
![](https://github.com/hutaoying/springcloud-learn/blob/master/springcloud-eureka/.README_images/83c40fcd.png)
windows 环境启动
```
D:\IdeaProject\springcloud-learn\springcloud-eureka\spring-cloud-eureka-cluster\target>java -jar spring-cloud-eureka-cluster-1.0-SNAPSHOT.jar --spring.profiles.active=po
rt1
// 启动三个terminal 
java -jar spring-cloud-eureka-cluster-1.0-SNAPSHOT.jar --spring.profiles.active=po
rt1
java -jar spring-cloud-eureka-cluster-1.0-SNAPSHOT.jar --spring.profiles.active=po
rt2
java -jar spring-cloud-eureka-cluster-1.0-SNAPSHOT.jar --spring.profiles.active=po
rt3



```