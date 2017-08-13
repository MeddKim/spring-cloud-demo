package com.demo.security.config.service;

import com.demo.security.config.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by Meddkim on 2017/8/1.
 */
@Service
public class UserInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findUserFallBack")
    public User findUser(Long Id){
        ResponseEntity<User> responseEntity =  restTemplate.getForEntity("http://COMPUTE-SERVICE/admin/user/{1}",User.class,110);
        User user = responseEntity.getBody();

        return user;
    }

    public Boolean addUser(User user){
        ResponseEntity<Boolean> responseEntity= restTemplate.postForEntity("http://COMPUTE-SERVICE/admin/user",user,Boolean.class);
        return responseEntity.getBody();
    }

    public void updateUser(User user){
        restTemplate.put("http://COMPUTE-SERVICE/admin/user",user);
    }

    public void deleteUser(Long id){
        restTemplate.delete("http://COMPUTE-SERVICE/admin/user/{1}",id);
    }

    public User findUserFallBack(Long id){
        return null;
    }
}
