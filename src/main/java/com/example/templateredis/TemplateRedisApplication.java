package com.example.templateredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TemplateRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateRedisApplication.class, args);
    }

}
