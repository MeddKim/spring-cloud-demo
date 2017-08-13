package com.demo.security.config.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Administrator
 * @date : 2017/3/16 0016
 * @Description:
 */
@Service
public class ComputeService {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallBack")
    public String addService(){
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20",String.class).getBody();
    }

    public String addServiceFallBack(){
        return "error";
    }
}
