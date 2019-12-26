package cn.com.agree.eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @RequestMapping(value = "/test1")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String test1(){
        throw new RuntimeException("测试出错");
    }

    public String fallbackMethod(){
        return "this is test1 fallback";
    }

}
