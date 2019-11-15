package cn.com.agree.main.controller;

import cn.com.agree.basis.unitTest.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private AService aService;

    @RequestMapping(value = "test")
    public String test(){
        System.err.println(aService.getAServiceName());
        System.out.println(" 测试 ");
        return "hello world";
    }

}
