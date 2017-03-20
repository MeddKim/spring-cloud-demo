package com.demo.security.config;

import com.demo.security.config.gateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@EnableZuulProxy
@SpringCloudApplication   //整合了@SpringBootApplication @@EnableDiscoveryClient @EnableCircuitBreaker
public class APIGatewayApplication
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(APIGatewayApplication.class).web(true).run(args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
