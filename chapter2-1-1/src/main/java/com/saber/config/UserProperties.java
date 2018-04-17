package com.saber.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sheng on 2018/4/17.
 */
@Component
public class UserProperties {

    @Value("${com.saber.name}")
    private String name;

    @Value(("${com.saber.address}"))
    private String address;

    @Value(("${com.saber.desc}"))
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
