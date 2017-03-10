package com.cloud.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Administrator
 * @date : 2017/3/10 0010
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World";
    }
}
