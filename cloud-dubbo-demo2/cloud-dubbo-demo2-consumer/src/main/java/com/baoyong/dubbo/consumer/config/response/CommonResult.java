package com.baoyong.dubbo.consumer.config.response;

import com.baoyong.dubbo.consumer.config.exception.ServiceExceptionEnum;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author JiangBaoyong
 * @date 2020/03/19
 **/
public class CommonResult<T> implements Serializable {
    /**
     * 结果编码
     */
    private int code;
    /**
     * 结果消息
     */
    private String message;
    /**
     * 结果内容
     */
    private T data;

    /**
     * 成功的返回结果
     *
     * @param data data
     * @param <T> T
     * @return CommonResult
     */
    public static  <T> CommonResult<T> success(T data) {
        CommonResult<T> commonResult = new CommonResult<T>();
        commonResult.setCode(ServiceExceptionEnum.SUCCESS.getCode())
                .setMessage(ServiceExceptionEnum.SUCCESS.getMessage())
                .setData(data);
        return commonResult;
    }

    /**
     * 失败时创建消息的静态方法
     * @param code code
     * @param message message
     * @param <T> T
     * @return CommonResult<T>
     */
    public static <T> CommonResult<T> errorResult(int code, String message) {
        Assert.isTrue(ServiceExceptionEnum.SUCCESS.getCode() != code, "code是错误的，不能是正常结果的code");
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(code).setMessage(message);
        return result;
    }

    /**
     * 传入ServiceExceptionEnum生成错误结果
     *
     * @param exceptionEnum enum
     * @param <T> T
     * @return CommonResult
     */
    public static <T> CommonResult<T> errorResult(ServiceExceptionEnum exceptionEnum) {
        return errorResult(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }

    /**
     * 将传入的result对象类型转换成另一泛型结果的对象
     *
     * @param commonResult CommonResult
     * @param <T> T
     * @return CommonResult
     */
    public static <T> CommonResult<T> errorResult(CommonResult<?> commonResult) {
        return errorResult(commonResult.getCode(), commonResult.getMessage());
    }

    public int getCode() {
        return code;
    }

    public CommonResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
