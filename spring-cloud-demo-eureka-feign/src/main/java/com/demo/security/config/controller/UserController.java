package com.demo.security.config.controller;

import com.demo.security.config.clientservice.UserService;
import com.demo.security.config.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Meddkim on 2017/8/4.
 */
@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findUSer(@PathVariable Long id){
        return userService.findUser(id);
    }
}
