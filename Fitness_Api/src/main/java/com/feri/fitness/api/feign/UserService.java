package com.feri.fitness.api.feign;

import com.feri.fitness.api.config.OpenFeignConfig;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.PlusOrderAddDto;
import com.feri.fitness.common.dto.UserAddDto;
import com.feri.fitness.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "FitnessUserServer",configuration = OpenFeignConfig.class)
public interface UserService {
    /**
     * 注册*/
    @PostMapping("/server/user/register.do")
    R add(@RequestBody UserAddDto dto);
    /**
     * plus会员订单*/
    @PostMapping("/server/plus/create.do")
    R create(@RequestBody PlusOrderAddDto dto);

    /**
     * 查询用户等级*/
    @PostMapping("/server/level/query.do")
    R queryLevel();
    /**
     * 查询用户plus会员*/
    @GetMapping("/server/userplus/query.do")
    R queryPlus();
    /**
     * 关注*/
    @PostMapping("/server/userfollow/add.do")
    R addFollow(@RequestParam int fuid);
    /**
     * 查询关注*/
    @GetMapping("/server/userfollow/follows.do")
    R follows();
    /**
     * 查询粉丝*/
    @GetMapping("/server/userfollow/fans.do")
    R fans();
    /**
     * 取消关注*/
    @PostMapping("/server/userfollow/del.do")
    R del(@RequestParam int id);

}
