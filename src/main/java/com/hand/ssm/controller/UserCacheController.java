package com.hand.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hand.ssm.domain.User;
import com.hand.ssm.utils.EhcacheUtil;
import net.sf.ehcache.Cache;

@Controller
@RequestMapping(value = "/cache")
public class UserCacheController {

    @RequestMapping("/addUser")
    public ModelAndView toIndex(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setAge(18);
        user.setName("jay");

        //保存到缓存中
        EhcacheUtil.getInstance().put("ehcacheGO", "userEch", user);
        System.out.println(user.hashCode());
        System.out.println("user:" + user.toString());

        mv.addObject("result", user);
        mv.setViewName("displayresult");
        return mv;
    }

    @RequestMapping("/addUser2")
    public ModelAndView toIndex2(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setAge(18);
        user.setName("jay2");

        //保存到缓存中
        EhcacheUtil.getInstance().put("ehcacheGO", "userEch", user);
        System.out.println(user.hashCode());
        System.out.println("user:" + user.toString());

        mv.addObject("result", user);
        mv.setViewName("displayresult");
        return mv;
    }


    @RequestMapping("/getUser")
    public ModelAndView toEhcahe(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        Cache cache = EhcacheUtil.getInstance().get("ehcacheGO");
        System.out.println("cache："+cache.hashCode());


        //从缓存中取数据
        User user = (User) EhcacheUtil.getInstance().get("ehcacheGO", "userEch");
        if (StringUtils.isEmpty(user)) {
            mv.addObject("result", new String("缓存中不存在要找的对象"));
            mv.setViewName("displayresult");
            return mv;
        }
        System.out.println("user"+user.hashCode());
        System.out.println("user:" + user.toString());
        mv.addObject("result", user);
        mv.setViewName("displayresult");
        return mv;
    }

    @RequestMapping("/removeUser")
    public ModelAndView remove(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //从缓存中取数据
        EhcacheUtil.getInstance().remove("ehcacheGO", "userEch");
        System.out.println("清空userEch");
        mv.addObject("result", new String("清空userEch"));
        mv.setViewName("displayresult");
        return mv;
    }


}
