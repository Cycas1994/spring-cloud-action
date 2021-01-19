package com.cycas.eurekafeignclient.config;

import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaFeignClient {

    @Override
    public String sayHiFromEurekaClient(String name) {
        return "hi," + name + ",sorry,error!";
    }

    @Override
    public String sayHiErrorFromEurekaClient(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
