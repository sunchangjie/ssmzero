package com.hand.ssm.service;

import com.hand.ssm.domain.User;

public interface IUserService {

    User getUsersByNameAndAge(String name, int age);

    User getAnotherUser(String name, int age);

    void evictUser(String name, int age);

    void evictAll();
}
