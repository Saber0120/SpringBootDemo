package com.saber.entity.s;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sheng on 2018/4/20.
 */
@Entity(name = "message")
@Table(name = "t_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1748200565655154319L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    public Long getId() {
        return id;
    }

    public Message() {
    }

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
