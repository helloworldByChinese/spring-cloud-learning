package com.baoyong.dubbo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author JiangBaoyong
 * @date 2020/03/18
 **/
public class UserDto implements Serializable {

    /**
     * 今天刚好遇到一个面试官提问
     * \@NotNull @NotEmpty @NotBlank 三者区别
     * 分别拦截递增：
     *      null .  "" .   "   "
     *  第三个就是多了个trim再校验
     */
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 15, message = "用户名长度需要在5-15之间")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 100, message = "年龄不能大于100")
    private short age;

    @NotBlank(message = "个人信息不能为空")
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
