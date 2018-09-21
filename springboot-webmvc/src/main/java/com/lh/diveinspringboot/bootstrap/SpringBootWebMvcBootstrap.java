package com.lh.diveinspringboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lh.diveinspringboot")
public class SpringBootWebMvcBootstrap {

    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(SpringBootWebMvcBootstrap.class);
        System.out.println("The service has started.");
    }

}
