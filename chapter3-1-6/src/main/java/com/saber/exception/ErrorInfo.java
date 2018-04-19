package com.saber.exception;

/**
 * Created by sheng on 2018/4/19.
 */
public class ErrorInfo<T> {

    public static final Integer OK = 200;
    public static final Integer ERROR = 500;

    private Integer code;

    private String message;

    private String url;

    private T t;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
