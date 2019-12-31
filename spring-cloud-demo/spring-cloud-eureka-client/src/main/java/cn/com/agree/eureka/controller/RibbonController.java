package cn.com.agree.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    private static String serviceName = "eureka-user-service";
    //    private static String GET_USER_URL = "http://EUREKA-USER-SERVICE/userName";
    private static String GET_USER_URL = "http://" + serviceName + "/userName";

    private LoadBalancerClient balancerClient;
    private RestTemplate restTemplate;

    @Autowired
    public RibbonController(LoadBalancerClient balancerClient, RestTemplate restTemplate) {
        this.balancerClient = balancerClient;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/ribbonTest")
    public String ribbonTest() {
//        ServiceInstance instance = balancerClient.choose(serviceName);
//        String host = instance.getHost();
//        int port = instance.getPort();
//        String result = restTemplate.exchange(GET_USER_URL, HttpMethod.POST, null, String.class).getBody();
        String result = restTemplate.getForObject(GET_USER_URL, String.class);

        return result;
    }
}
