package spring.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date : 2017/3/16 0016
 * @Description:
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String from;

    @RequestMapping
    public String from(){
        return this.from;
    }
}