package com.baoyong.dubbo.consumer.config.exception;

/**
 * @author JiangBaoyong
 * @date 2020/03/19
 **/
public class ServiceException extends RuntimeException {
    /**
     * 结果编码
     */
    private final int code;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ServiceExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public int getCode() {
        return code;
    }
}
