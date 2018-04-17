package com.saber.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sheng on 2018/4/17.
 */
@Component
@ConfigurationProperties(prefix = "com.saber")
public class UserConfig {

    private String username;

    private List<String> url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
