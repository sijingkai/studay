package com.feri.fitness.api.api;

import com.feri.fitness.api.feign.CourseOrderService;
import com.feri.fitness.api.feign.CourseService;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.CourseAddDto;
import com.feri.fitness.common.dto.CourseOrderDto;
import com.feri.fitness.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/courseorder/")
@Api(tags = "实现课程服务相关操作")
public class CourseOrderApi {
    /**
    *注入业务逻辑层对象*/
    @Resource
    private CourseOrderService service;

    /**
     * 新增内容*/
    @PostMapping("save.do")
    public R save(@RequestBody CourseOrderDto dto){
        return service.save(dto);
    }
    /**
     * 查询 所有数据*/
    @GetMapping("all.do")
    public R all(){
        return service.all();
    }

    /**
     * 查询 我的订单*/
    @GetMapping("my.do")
    public R my(@RequestParam int flag,HttpServletRequest request){
        return service.my(flag);
    }

}