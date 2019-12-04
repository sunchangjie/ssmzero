package com.hand.ssm.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hand.ssm.domain.User;
import com.hand.ssm.service.IUserService;


@Service
@Cacheable(value = "users")
public class UserServiceImpl implements IUserService {
    @Override
    public User getUsersByNameAndAge(String name, int age) {
        System.out.println("--正在执行findUsersByNameAndAge()查询方法--");
        return new User(name, age);
    }

    @Override
    public User getAnotherUser(String name, int age) {
        System.out.println("--正在执行findAnotherUser()查询方法--");
        return new User(name, age);
    }


    // 指定根据name、age参数清除缓存
    @CacheEvict(value = "users")
    @Override
    public void evictUser(String name, int age) {
        System.out.println("--正在清空" + name
                + " , " + age + "对应的缓存--");
    }

    // 指定清除user缓存区所有缓存数据
    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void evictAll() {
        System.out.println("--正在清空整个缓存--");
    }
}
