package cn.com.agree.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@EnableCircuitBreaker
//@EnableHystrixDashboard
@EnableHystrix
@RestController
@EnableDiscoveryClient
public class ConfigServerApplication {

    @Autowired
    Hello hello;

    @RequestMapping("/")
    public String home(){
        return hello.hello();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    @Component
    public class Hello{
        @HystrixCommand(fallbackMethod = "fallback")
        public String hello(){
            System.err.println("hello, config server");
            return "hello, config server";
        }

        public String fallback(){
            System.err.println("hello, config server fallback");
            return "hello, config server fallback";
        }
    }
}
