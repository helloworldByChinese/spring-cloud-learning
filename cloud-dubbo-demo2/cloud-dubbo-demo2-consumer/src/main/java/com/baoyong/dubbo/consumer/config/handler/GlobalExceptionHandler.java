package com.baoyong.dubbo.consumer.config.handler;

import com.baoyong.dubbo.consumer.config.exception.ServiceException;
import com.baoyong.dubbo.consumer.config.exception.ServiceExceptionEnum;
import com.baoyong.dubbo.consumer.config.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类
 * 定义处理边界
 *
 * @author JiangBaoyong
 * @date 2020/03/19
 **/
@ControllerAdvice(basePackages = "com.baoyong.dubbo.consumer.controller")
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String SPLIT_SIGN = ";";
    /**
     * 处理ServiceExceptionHandler异常
     * @param req req
     * @param ex ex
     * @return CommonResult
     */
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest req, ServiceException ex) {
        logger.info("[ServiceException]:" + ex.getMessage());
        return CommonResult.errorResult(ex.getCode(), ex.getMessage());
    }

    /**
     * 参数校验结果拦截处理
     *
     * @param req req
     * @param ex ex
     * @return CommonResult
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResult constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException ex) {
        logger.info("[ConstraintViolationException]:" + ex);
        // 拼接错误
        StringBuilder errorDetail = new StringBuilder();
        for (ConstraintViolation violation : ex.getConstraintViolations()) {
            if (errorDetail.length() > 0) {
                errorDetail.append(SPLIT_SIGN);
            }
            errorDetail.append(violation.getMessage());
        }
        return CommonResult.errorResult(ServiceExceptionEnum.FAIL.getCode(),
                ServiceExceptionEnum.FAIL.getMessage() + errorDetail.toString());
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e) {
        // 记录异常日志
        logger.error("[exceptionHandler]", e);
        // 返回 ERROR CommonResult
        return CommonResult.errorResult(ServiceExceptionEnum.SYS_FAIL);
    }

}
