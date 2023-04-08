package com.feri.fitness.api.feign;

import com.feri.fitness.api.config.OpenFeignConfig;
import com.feri.fitness.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "FitnessNetworkServer")
public interface PayService {
    @GetMapping("/server/pay/status.do")
    R status(@RequestParam String no);
}
