package com.lh.diveinspringboot.config;


import com.lh.diveinspringboot.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.set(0, new PropertiesHttpMessageConverter()); // 添加到集合首位
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

}
