package cn.itcast.order;

import cn.itcast.feign.clients.userClient;
import cn.itcast.feign.config.FeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@EnableFeignClients(clients = {userClient.class}, defaultConfiguration = FeignConfiguration.class)
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入Spring容器
     * LoadBalanced 负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 通过定义Irule 实现可以修改负载均衡规则,访问服务随机
//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }
}