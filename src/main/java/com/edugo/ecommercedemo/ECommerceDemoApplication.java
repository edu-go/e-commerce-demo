package com.edugo.ecommercedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ECommerceDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ECommerceDemoApplication.class, args);
    }
}
