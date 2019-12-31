package cn.com.agree.user.controller;

import cn.com.agree.user.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    private UserInfo userInfo;

    @Autowired
    public UserController(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/userName")
    public String userName(){
        return userInfo.getUsername() + " from " + port;
    }

    public String fallback(){
        return "this is fallback";
    }
}
