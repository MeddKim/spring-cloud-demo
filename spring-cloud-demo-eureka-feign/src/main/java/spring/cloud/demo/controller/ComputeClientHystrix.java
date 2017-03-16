package spring.cloud.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Administrator
 * @date : 2017/3/16 0016
 * @Description:
 */
@Component
public class ComputeClientHystrix implements ComputeClient{
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -999;
    }
}
