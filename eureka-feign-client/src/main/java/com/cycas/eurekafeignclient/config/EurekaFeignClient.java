package com.cycas.eurekafeignclient.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", fallback = HiHystrix.class)
public interface EurekaFeignClient {

    @GetMapping("/hi")
    String sayHiFromEurekaClient(@RequestParam String name);

    @GetMapping("/hiError")
    String sayHiErrorFromEurekaClient(@RequestParam String name);
}
