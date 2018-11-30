package com.free.code.entity;

/**
 * @ClassName ResultEntity
 * @Description TODO
 * @Author hsiangcn@sina.com
 * @Date 2018/11/29 14:01
 * @Version 1.0
 */
public class ResultEntity<T> {

    private String success;
    private String message;
    private T data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
