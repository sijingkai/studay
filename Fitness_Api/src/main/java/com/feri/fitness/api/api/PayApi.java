package com.feri.fitness.api.api;

import com.feri.fitness.api.feign.PayService;
import com.feri.fitness.common.vo.R;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api/pay/")
@Api(tags = "实现支付服务的各种操作")
public class PayApi {
    @Resource
    private PayService service;

    @GetMapping("status.do")
    public R status(@RequestParam String no){
        return service.status(no);
    }
}
