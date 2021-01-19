package com.cycas.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Value("${server.port} ")
    private String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "hello " + name + ",i am from port:" + port;
    }

    @GetMapping("/hiError")
    public String hiError(@RequestParam String name) {
        int i = 1/0;
        return "hello " + name + ",i am from port:" + port;
    }

    public static void main(String[] args) {
        String str = "零基础通关班&&,&& &&,&& ";
        System.out.println(str.split("&&,&&").length);
    }
}
