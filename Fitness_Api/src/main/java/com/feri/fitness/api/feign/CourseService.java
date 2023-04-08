package com.feri.fitness.api.feign;

import com.feri.fitness.api.config.OpenFeignConfig;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.CourseAddDto;
import com.feri.fitness.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "FitnessCourseServer",configuration = OpenFeignConfig.class)
public interface CourseService {
    /**
     * 新增内容*/
    @PostMapping("/server/course/save.do")
    public R save(@RequestBody CourseAddDto course);
    /**
     * 查询 条件*/
    @GetMapping("/server/course/all.do")
    public R all(@RequestParam int ctype);
    /**
     * 查询 最新课程*/
    @GetMapping("/server/course/topnew.do")
    public R queryNew();
    /**
     * 修改 审核课程*/
    @PostMapping("/server/course/update.do")
    R update(@RequestParam int cid,@RequestParam int flag);
}
