package com.feri.fitness.api.api;

import com.feri.fitness.api.feign.MoodService;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.MoodAddDto;
import com.feri.fitness.common.dto.MoodCommentAddDto;
import com.feri.fitness.common.dto.MoodRefwordDto;
import com.feri.fitness.common.vo.R;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/mood/")
@Api(tags = "实现社区服务的各种操作")
public class MoodApi {
    @Resource
    private MoodService service;
    @ApiOperation("发布动态")
    @PostMapping("add.do")
    public R add(@RequestBody MoodAddDto dto, HttpServletRequest request){
        return service.add(dto);
    }
    @ApiOperation("转发动态")
    @PostMapping("forward.do")
    public R forward(@RequestBody MoodRefwordDto dto, HttpServletRequest request){
        return service.forward(dto);
    }
    @ApiOperation("查询热门动态")
    @GetMapping("hot.do")
    public R hot(){
        return service.hot();
    }

    @ApiOperation("动态删除")
    @GetMapping("del.do")
    public R del(@RequestParam int mid){
        return service.del(mid);
    }
    @ApiOperation("查询关注动态")
    @GetMapping("follow.do")
    public R follow(HttpServletRequest request){
        return service.follow();
    }
    @ApiOperation("查询同城动态")
    @GetMapping("city.do")
    public R city(@RequestParam String city){
        return service.city(city);
    }
    @ApiOperation("新增评论")
    @PostMapping("addcomment.do")
    public R addComment(@RequestBody MoodCommentAddDto dto, HttpServletRequest request){
        return service.add(dto);
    }
    @ApiOperation("新增评论回复")
    @PostMapping("addrep.do")
    public R addRep(@RequestBody MoodCommentAddDto dto, HttpServletRequest request){
        return service.addRep(dto);
    }
    @ApiOperation("查询动态的评论列表")
    @GetMapping("querycomment.do")
    public R queryComments(int mid){
        return service.query(mid);
    }
    @ApiOperation("动态收藏")
    @PostMapping("addcollect.do")
    public R add(@RequestParam int mid, HttpServletRequest request){
        return service.addCollect(mid);
    }
    @ApiOperation("查询用户的收藏列表")
    @GetMapping("collect.do")
    public R my(HttpServletRequest request){
        return service.myCollect();
    }

}
