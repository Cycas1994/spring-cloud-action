package com.cycas.eurekafeignclient.controller;

import com.cycas.eurekafeignclient.config.EurekaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return eurekaFeignClient.sayHiFromEurekaClient(name);
    }

    @GetMapping("/hiError")
    public String sayHiError(@RequestParam String name) {
        return eurekaFeignClient.sayHiErrorFromEurekaClient(name);
    }
}
