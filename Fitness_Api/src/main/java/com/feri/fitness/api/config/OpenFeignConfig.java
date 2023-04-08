package com.feri.fitness.api.config;

import com.feri.fitness.common.config.SystemConfig;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class OpenFeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //1.获取请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //2.把需要传递的请求消息头传输给OpenFeign
        requestTemplate.header(SystemConfig.HEADER_UID,request.getHeader(SystemConfig.HEADER_UID));
        requestTemplate.header(SystemConfig.HEADER_TOKEN,request.getHeader(SystemConfig.HEADER_TOKEN));
        //…… 多个请求消息头，以此类推
    }
}
