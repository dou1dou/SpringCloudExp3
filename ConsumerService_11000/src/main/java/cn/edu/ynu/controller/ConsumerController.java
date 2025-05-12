package cn.edu.ynu.controller;

import cn.edu.ynu.feign.ServiceProviderService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Resource
    private ServiceProviderService serviceInstance;

    @GetMapping("/callFeign/backendA")
    @CircuitBreaker(name = "backendA", fallbackMethod = "helloGetFeignDown")
    @RateLimiter(name = "rate1", fallbackMethod = "helloGetFeignDown")
    @Bulkhead(name = "bulkheadA", fallbackMethod = "helloGetFeignDown")
    public String helloGetFeignA() {
        return serviceInstance.helloGet();
    }

    @GetMapping("/callFeign/backendB")
    @CircuitBreaker(name = "backendB", fallbackMethod = "helloGetFeignDown")
    @RateLimiter(name = "rate1", fallbackMethod = "helloGetFeignDown")
    @Bulkhead(name = "bulkheadB", fallbackMethod = "helloGetFeignDown")
    public String helloGetFeignB() {
        return serviceInstance.helloGet();
    }

    public String helloGetFeignDown(Throwable throwable) {
        return "服务状态异常";
    }

}
