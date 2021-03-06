package com.lh.diveinspringboot.annotation;

import com.lh.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
//@Import({HelloWorldImportSelector.class})
@Import({HelloWorldConfiguration.class})
public @interface EnableHelloWorld {
}