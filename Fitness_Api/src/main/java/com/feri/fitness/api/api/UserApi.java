package com.feri.fitness.api.api;

import com.feri.fitness.api.feign.UserService;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.PlusOrderAddDto;
import com.feri.fitness.common.dto.UserAddDto;
import com.feri.fitness.common.vo.R;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/user/")
@Api(tags = "实现用户服务的各种操作")
public class UserApi {
    @Resource
    private UserService service;

    @PostMapping("register.do")
    public R add(@RequestBody UserAddDto dto){
        return service.add(dto);
    }
    @PostMapping("create.do")
    public R create(@RequestBody PlusOrderAddDto dto, HttpServletRequest request) {
        return service.create(dto);
    }
    @GetMapping("follows.do")
    public R follows(HttpServletRequest request){
        return service.follows();
    }
    @GetMapping("fans.do")
    public R fans(HttpServletRequest request){
        return service.fans();
    }
    @PostMapping("add.do")
    public R add(@RequestParam int fuid){
        return service.addFollow(fuid);
    }
    @PostMapping("del.do")
    public R del(@RequestParam int id){
        return service.del(id);
    }
    @PostMapping("querylevel.do")
    public R query(HttpServletRequest request){
        return service.queryLevel();
    }
    @GetMapping("queryplus.do")
    public R queryPlus(HttpServletRequest request){
        return service.queryPlus();
    }

}
