package com.lh.diveinspringboot.configuration;

import com.lh.diveinspringboot.annotation.EnableHelloWorld;
import com.lh.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "we-win") // 条件装配
public class HelloWorldAutoConfiguration {
}
