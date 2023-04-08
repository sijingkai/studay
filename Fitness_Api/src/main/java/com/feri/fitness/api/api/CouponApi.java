package com.feri.fitness.api.api;

import com.feri.fitness.api.feign.CouponService;
import com.feri.fitness.api.feign.CourseService;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.CouponAddDto;
import com.feri.fitness.common.dto.CouponAuditDto;
import com.feri.fitness.common.dto.CourseAddDto;
import com.feri.fitness.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/coupon/")
@Api(tags = "实现优惠券服务相关操作")
public class CouponApi {
    /**
    *注入业务逻辑层对象*/
    @Resource
    private CouponService service;


    @PostMapping("save.do")
    public R save(@RequestBody CouponAddDto dto){
        return service.save(dto);
    }
    @PostMapping("audit.do")
    public R audit(@RequestBody CouponAuditDto dto){
        return service.audit(dto);
    }
    @GetMapping("coupons.do")
    public R all(){
        return service.all();
    }
    @PostMapping("add.do")
    public R add(@RequestParam int cid, HttpServletRequest request) throws InterruptedException {
        return service.add(cid);
    }
    @GetMapping("my.do")
    public R my(HttpServletRequest request){
        return service.my();
    }
}