package com.saber.entity.p;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sheng on 2018/4/20.
 */
@Entity(name = "user")
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1748200565655154319L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Long getId() {
        return id;
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
