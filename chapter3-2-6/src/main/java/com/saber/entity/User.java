package com.saber.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/22.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7993768535009139109L;

    private String username;

    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
