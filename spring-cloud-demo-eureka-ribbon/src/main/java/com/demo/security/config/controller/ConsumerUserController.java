package com.demo.security.config.controller;

import com.demo.security.config.domain.User;
import com.demo.security.config.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Meddkim on 2017/8/1.
 */
@RestController
@RequestMapping("/admin")
public class ConsumerUserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findUser(@PathVariable Long id){
        User user = userInfoService.findUser(id);

        return user;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        Boolean isSuccess = userInfoService.addUser(user);

        return isSuccess;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable Long id){
        userInfoService.deleteUser(id);

        return true;
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user){
        userInfoService.updateUser(user);

        return true;
    }
}
