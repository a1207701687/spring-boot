package cn.com.agree.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class UserApplication {

    @RequestMapping(value = "/")
    public String home(){
        return "User Service";
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
