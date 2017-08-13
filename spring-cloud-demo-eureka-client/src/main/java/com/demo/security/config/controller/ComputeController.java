package com.demo.security.config.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author: Administrator
 * @date : 2017/3/16 0016
 * @Description:
 */
@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    /**
     * 该方法有完成两项工作：
     *  1. 计算url中传入的参数的和
     *  2. 打印DiscoveryClient基本信息
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a,@RequestParam Integer b){
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add , host"+instance.getHost()+", service_id:"+instance.getServiceId()+", result:"+r);
        return r;
    }

}
