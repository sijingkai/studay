package com.feri.fitness.api.feign;

import com.feri.fitness.api.config.OpenFeignConfig;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.CourseAddDto;
import com.feri.fitness.common.dto.CourseOrderDto;
import com.feri.fitness.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "FitnessCourseServer",configuration = OpenFeignConfig.class)
public interface CourseOrderService {
    /**
     * 新增内容*/
    @PostMapping("/server/courseOrder/save.do")
    public R save(@RequestBody CourseOrderDto dto);
    /**
     * 查询 所有数据*/
    @GetMapping("/server/courseOrder/all.do")
    public R all();

    /**
     * 查询 我的订单*/
    @GetMapping("/server/courseOrder/my.do")
    public R my(@RequestParam int flag);
}
