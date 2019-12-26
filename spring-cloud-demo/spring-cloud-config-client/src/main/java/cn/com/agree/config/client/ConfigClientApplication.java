package cn.com.agree.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    @Autowired
    UserInfo userInfo;

    @RequestMapping("/")
    public String home(){
        return userInfo.getUsername();
    }


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
