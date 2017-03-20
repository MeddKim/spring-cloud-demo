package com.demo.security.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication
{
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(EurekaClientApplication.class, args);
        new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }
}
