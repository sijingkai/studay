package com.feri.fitness.api.feign;

import com.feri.fitness.api.config.OpenFeignConfig;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.CouponAddDto;
import com.feri.fitness.common.dto.CouponAuditDto;
import com.feri.fitness.common.dto.CourseAddDto;
import com.feri.fitness.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "FitnessCouponServer",configuration = OpenFeignConfig.class)
public interface CouponService {
    @PostMapping("/server/coupon/save.do")
    public R save(@RequestBody CouponAddDto dto);
    @PostMapping("/server/coupon/audit.do")
    public R audit(@RequestBody CouponAuditDto dto);
    @GetMapping("/server/coupon/coupons.do")
    public R all();
    @PostMapping("/server/coupon/add.do")
    public R add(@RequestParam int cid);
    @GetMapping("/server/coupon/my.do")
    public R my();
}
