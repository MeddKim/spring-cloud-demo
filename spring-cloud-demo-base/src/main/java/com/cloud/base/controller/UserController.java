package com.cloud.base.controller;

import com.cloud.base.domain.User;
import com.cloud.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date : 2017/7/26 0026
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable Long id){
        User user = userService.findUserByPrimaryKey(id);

        return user;
    }
}
