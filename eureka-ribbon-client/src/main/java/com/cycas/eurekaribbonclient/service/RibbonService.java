package com.cycas.eurekaribbonclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RibbonService {

    private static final Logger logger = LoggerFactory.getLogger(RibbonService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
    }, fallbackMethod = "fallback")
    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
    }

    @HystrixCommand(fallbackMethod = "fallback",
    commandProperties = {
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="5000"),
    })
    public String hiError(String name) {
        logger.info("call hiError...");
        return restTemplate.getForObject("http://eureka-client/hiError?name=" + name, String.class);
    }

    public String fallback(String name) {
        return "Hi," + name + ", sorry, error!";
    }
}
