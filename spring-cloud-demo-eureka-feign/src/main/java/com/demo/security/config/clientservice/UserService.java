package com.demo.security.config.clientservice;

import com.demo.security.config.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Meddkim on 2017/8/4.
 */
@FeignClient(value = "compute-service",fallback = UserServiceFallback.class)
@RequestMapping("/admin")
public interface UserService {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User findUser(@PathVariable Long id);
}
