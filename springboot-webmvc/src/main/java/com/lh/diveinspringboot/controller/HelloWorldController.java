package com.lh.diveinspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("test")
    public String indexTest(@RequestHeader("Accept-Language") String acceptLanguage,
                            @CookieValue("JSESSIONID") String jsessionId,
                            Model model) {
        model.addAttribute("acceptLanguage", acceptLanguage);
        model.addAttribute("jsessionId", jsessionId);
        model.addAttribute("message", "Hello,World");
        return "index";
    }

//    @RequestMapping("error")
//    public String indexError(@RequestParam int value,
//                             Model model) {
//        model.addAttribute("message", "Hello,World");
//        return "index";
//    }

}
