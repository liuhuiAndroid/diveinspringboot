package com.lh.diveinspringboot.controller;

import com.lh.diveinspringboot.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user",
            produces = "application/json;charset=GBK",
            consumes = "application/json;charset=UTF-8")
    public User user(@RequestBody User user) {
        return user;
    }

}
