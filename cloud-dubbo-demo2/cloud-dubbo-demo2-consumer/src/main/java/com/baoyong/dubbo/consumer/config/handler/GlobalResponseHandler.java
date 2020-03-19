package com.baoyong.dubbo.consumer.config.handler;

import com.baoyong.dubbo.consumer.config.response.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 回传结果统一格式处理,
 * 防止出现部分接口返回格式未处理的
 *
 * @author JiangBaoyong
 * @date 2020/03/19
 **/
@ControllerAdvice(basePackages = "com.baoyong.dubbo.consumer.controller")
public class GlobalResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof CommonResult) {
            return body;
        } else {
            return CommonResult.success(body);
        }
    }
}
