package com.lh.diveinspringboot.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lh.diveinspringboot")
public class SpringBootViewBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class);
    }

}
