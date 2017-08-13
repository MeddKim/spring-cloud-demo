package com.demo.security.config.command;

import com.demo.security.config.domain.User;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Meddkim on 2017/8/2.
 */
public class UserCommand extends HystrixCommand<User>{

    private RestTemplate restTemplate;
    private Long id;


    public UserCommand(Setter setter,RestTemplate restTemplate,Long id){
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }
    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://COMPUTE-SERVICE/admin/user/{1}",User.class,id);
    }

    @Override
    protected User getFallback(){
        return new User();
    }
}
