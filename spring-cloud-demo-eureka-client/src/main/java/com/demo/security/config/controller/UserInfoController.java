package com.demo.security.config.controller;

import com.demo.security.config.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Created by Meddkim on 2017/8/1.
 */
@RestController
@RequestMapping("/admin")
public class UserInfoController {

    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findUser(@PathVariable Long id){
        logger.info("需要查询的用户ID是：{}",id);

        User user = new User();
        user.setName("张三");
        user.setAge(25);
        user.setRemark("演示用户");

        return user;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Boolean addUser(@RequestBody User user){

        String name = user.getName();
        Integer age = user.getAge();
        String remark = user.getRemark();
        logger.info("创建用户操作用户名为：{}；年龄为：{}；备注：{}",name,age,remark);

        return true;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Boolean delUser(@PathVariable Long id){
        logger.info("需要删除的用户ID是：{}",id);

        return false;
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public Boolean updateUser(@RequestBody User user){

        String name = user.getName();
        Integer age = user.getAge();
        String remark = user.getRemark();
        logger.info("修改用户操作，用户名为：{}；年龄为：{}；备注：{}",name,age,remark);

        return true;
    }
}
