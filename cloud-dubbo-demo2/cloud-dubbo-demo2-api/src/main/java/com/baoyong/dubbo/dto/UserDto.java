package com.baoyong.dubbo.dto;

import java.io.Serializable;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
public class UserDto implements Serializable {

    private Integer id;

    private String name;

    private short age;

    private String message;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public short getAge() {
        return age;
    }

    public UserDto setAge(short age) {
        this.age = age;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UserDto setMessage(String message) {
        this.message = message;
        return this;
    }
}
