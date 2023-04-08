package com.feri.fitness.api.api;

import com.feri.fitness.api.feign.CourseService;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.CourseAddDto;
import com.feri.fitness.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/course/")
@Api(tags = "实现课程服务相关操作")
public class CourseApi {
    /**
    *注入业务逻辑层对象*/
    @Resource
    private CourseService service;
    /**
    * 新增内容*/
    @ApiOperation("新增课程")
    @PostMapping("save.do")
    public R save(@RequestBody CourseAddDto course, HttpServletRequest request){
       return service.save(course);
    }
    /**
    * 查询 条件*/
    @ApiOperation("条件查询")
    @GetMapping("all.do")
    public R all(@RequestParam int ctype){
       return service.all(ctype);
    }
    /**
    * 查询 最新课程*/
    @ApiOperation("最新课程")
    @GetMapping("topnew.do")
    public R queryNew(){
        return service.queryNew();
    }
    /**
    * 修改 审核课程*/
    @ApiOperation("审核课程")
    @PostMapping("update.do")
    public R update(@RequestParam int cid,@RequestParam int flag){
        return service.update(cid, flag);
    }
}