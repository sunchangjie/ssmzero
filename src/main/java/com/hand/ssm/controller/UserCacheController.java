package com.hand.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hand.ssm.domain.User;
import com.hand.ssm.service.IUserService;

@Controller
@RequestMapping(value = "/cache")
public class UserCacheController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUsersByNameAndAge")
    public User getUsersByNameAndAge() {
        return userService.getUsersByNameAndAge("scj", 18);
    }


    @RequestMapping(value = "/getAnotherUser")
    public User getAnotherUser(String name, int age) {
        return userService.getAnotherUser("scj", 18);
    }


    @RequestMapping(value = "/getUsersByNameAndAge")
    public void evictUser(String name, int age) {
        userService.evictUser("scj", 18);
    }

    @RequestMapping(value = "/getUsersByNameAndAge")
    public void evictAll() {
        userService.evictAll();
    }


}
