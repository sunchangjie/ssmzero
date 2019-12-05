package com.hand.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hand.ssm.domain.User;
import com.hand.ssm.service.IUserService;
import sun.misc.Cache;

@Controller
@RequestMapping(value = "/cache")
public class UserCacheController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUsersByNameAndAge.do")
    public ModelAndView getUsersByNameAndAge() {
        ModelAndView mv = new ModelAndView();
        User user = userService.getUsersByNameAndAge("scj", 18);
        mv.addObject("result", user);
        mv.setViewName("displayresult");
        return mv;
    }


    @RequestMapping(value = "/getAnotherUser.do")
    public ModelAndView getAnotherUser(String name, int age) {
        ModelAndView mv = new ModelAndView();
        User user = userService.getAnotherUser("scj", 18);
        mv.addObject("result", user);
        mv.setViewName("displayresult");
        return mv;
    }


    @RequestMapping(value = "/evictUser.do")
    public ModelAndView evictUser(String name, int age) {
        ModelAndView mv = new ModelAndView();
        userService.evictUser("scj", 18);
        mv.addObject("result", "清除完成evictUser");
        mv.setViewName("displayresult");
        return mv;
    }

    @RequestMapping(value = "/evictAll.do")
    public ModelAndView evictAll() {
        ModelAndView mv = new ModelAndView();
        userService.evictAll();
        mv.addObject("result", "清除完成evictAll");
        mv.setViewName("displayresult");
        return mv;
    }

    private CacheManager manager;

    @RequestMapping(value = "/getUserCache.do")
    public ModelAndView getUserCache() {
        ModelAndView mv = new ModelAndView();
        User user = (User) manager.getCache("users");
        System.out.println(user);
        userService.evictAll();
        mv.addObject("result", user);
        mv.setViewName("displayresult");
        return mv;
    }

}
