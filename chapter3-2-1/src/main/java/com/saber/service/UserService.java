package com.saber.service;

/**
 * Created by sheng on 2018/4/19.
 */
public interface UserService {

    void create(String name, Integer age);

    void deleteByName(String name);

    Integer getUserCount();

    void deleteAll();
}
