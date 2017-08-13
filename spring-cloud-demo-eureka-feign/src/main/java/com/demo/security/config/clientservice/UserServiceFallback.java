package com.demo.security.config.clientservice;

import com.demo.security.config.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Meddkim on 2017/8/4.
 */
@Component
public class UserServiceFallback implements UserService{
    @Override
    public User findUser(@PathVariable("id") Long id) {
        User user = new User();
        user.setName("未知用户");
        return user;
    }
}
