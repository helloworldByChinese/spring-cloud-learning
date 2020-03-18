package com.baoyong.dubbo.consumer.dto;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
public class UserDtoRibbon {
    private Integer id;

    private String name;

    private short age;

    private String message;

    public Integer getId() {
        return id;
    }

    public UserDtoRibbon setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDtoRibbon setName(String name) {
        this.name = name;
        return this;
    }

    public short getAge() {
        return age;
    }

    public UserDtoRibbon setAge(short age) {
        this.age = age;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UserDtoRibbon setMessage(String message) {
        this.message = message;
        return this;
    }
}
