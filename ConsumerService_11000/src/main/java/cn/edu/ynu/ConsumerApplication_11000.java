package cn.edu.ynu;

import cn.edu.ynu.ruler.CustomLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClients(defaultConfiguration = CustomLoadBalanceConfig.class)
public class ConsumerApplication_11000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication_11000.class, args);
    }
}
