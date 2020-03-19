package com.baoyong.dubbo.consumer.config.exception;

/**
 * 失败枚举类
 *
 * @author byJiang
 * @date 2020.03.19
 */
public enum ServiceExceptionEnum {
    /**
     * 成功返回消息
     */
    SUCCESS(200, "处理成功"),
    /**
     * 请求参数异常返回消息
     */
    FAIL(400, "参数异常："),
    /**
     * 系统异常
     */
    SYS_FAIL(404, "系统异常");

    private final int code;

    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
