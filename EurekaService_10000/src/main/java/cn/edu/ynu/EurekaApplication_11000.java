package cn.edu.ynu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication_11000 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_11000.class, args);
    }
}
