package com.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Administrator
 * @date : 2017/3/17 0017
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
