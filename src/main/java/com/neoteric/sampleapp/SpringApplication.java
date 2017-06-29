package com.neoteric.sampleapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@SuppressWarnings({"squid:S1118", "squid:S2095"})
public class SpringApplication {
    public static void main(String... args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}
