package com.feri.fitness.api.feign;

import com.feri.fitness.api.config.OpenFeignConfig;
import com.feri.fitness.common.config.SystemConfig;
import com.feri.fitness.common.dto.MoodAddDto;
import com.feri.fitness.common.dto.MoodCommentAddDto;
import com.feri.fitness.common.dto.MoodRefwordDto;
import com.feri.fitness.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "FitnessCommunityServer",configuration = OpenFeignConfig.class)
public interface MoodService {

    @PostMapping("/server/mood/add.do")
    R add(@RequestBody MoodAddDto dto);
    @PostMapping("/server/mood/forward.do")
    R forward(@RequestBody MoodRefwordDto dto);
    @GetMapping("/server/mood/del.do")
    R del(@RequestParam int mid);

    @GetMapping("/server/mood/hot.do")
    R hot();

    @GetMapping("/server/mood/follow.do")
    R follow();
    @GetMapping("/server/mood/city.do")
    R city(@RequestParam String city);
    @PostMapping("/server/moodComment/add.do")
    R add(@RequestBody MoodCommentAddDto dto);
    @PostMapping("/server/moodComment/addrep.do")
    R addRep(@RequestBody MoodCommentAddDto dto);
    @GetMapping("/server/moodComment/query.do")
    R query(@RequestParam int mid);
    @PostMapping("/server/moodCollect/add.do")
    R addCollect(@RequestParam int mid);
    @GetMapping("/server/moodCollect/my.do")
    R myCollect();


}