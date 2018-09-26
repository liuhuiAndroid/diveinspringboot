package com.lh.diveinspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Properties;

@Controller
public class PropertiesRestController {

    @PostMapping(
            value = "/add/props",
            consumes = "text/properties;charset=UTF-8"
    )
    public Properties addProperties(Properties properties) {
        return properties;
    }

}
