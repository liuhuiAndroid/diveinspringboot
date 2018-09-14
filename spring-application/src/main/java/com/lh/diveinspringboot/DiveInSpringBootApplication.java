package com.lh.diveinspringboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

//@SpringBootApplication
public class DiveInSpringBootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DiveInSpringBootApplication.class, args);

//        SpringApplication springApplication = new SpringApplication(DiveInSpringBootApplication.class);
//        springApplication.setBannerMode(Banner.Mode.CONSOLE);
//        springApplication.setWebApplicationType(WebApplicationType.NONE); // 非Web类型
//        springApplication.setAdditionalProfiles("prod"); // 线上方式
//        springApplication.setHeadless(true);
//        springApplication.run(args);

//        Set<String> sources = new HashSet();
//        sources.add(DiveInSpringBootApplication.class.getName());
//        SpringApplication springApplication = new SpringApplication();
//        springApplication.setSources(sources);
//        springApplication.setBannerMode(Banner.Mode.CONSOLE);
//        springApplication.setWebApplicationType(WebApplicationType.NONE); // 非Web类型
//        springApplication.setAdditionalProfiles("prod"); // 线上方式
//        springApplication.setHeadless(true);
//        springApplication.run(args);

//        new SpringApplicationBuilder(DiveInSpringBootApplication.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .web(WebApplicationType.SERVLET)
//                .profiles("prod")
//                .headless(true)
//                .run(args);

        Set<String> sources = new HashSet();
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.print("Bean:" + context.getBean(ApplicationConfiguration.class));
    }


    @SpringBootApplication
    public static class ApplicationConfiguration {
    }

}
