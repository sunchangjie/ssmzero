package com.hand.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hand.ssm.domain.User;
import com.hand.ssm.service.IUserService;
import sun.misc.Cache;

@Controller
@RequestMapping(value = "/cache")
public class UserCacheController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUsersByNameAndAge.do")
    public User getUsersByNameAndAge() {
        return userService.getUsersByNameAndAge("scj", 18);
    }


    @RequestMapping(value = "/getAnotherUser.do")
    public User getAnotherUser(String name, int age) {
        return userService.getAnotherUser("scj", 18);
    }


    @RequestMapping(value = "/evictUser.do")
    public void evictUser(String name, int age) {
        userService.evictUser("scj", 18);
    }

    @RequestMapping(value = "/evictAll.do")
    public void evictAll() {
        userService.evictAll();
    }

    private CacheManager manager;

    @RequestMapping(value = "/getUserCache.do")
    public void getUserCache() {
        User user =  (User)manager.getCache("users");
        System.out.println(user);
        userService.evictAll();
    }

}
