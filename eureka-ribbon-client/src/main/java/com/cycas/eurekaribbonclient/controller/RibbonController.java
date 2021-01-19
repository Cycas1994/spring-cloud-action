package com.cycas.eurekaribbonclient.controller;

import com.cycas.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return ribbonService.hi(name);
    }

    @GetMapping("/hiError")
    public String hiError(@RequestParam String name) {
        return ribbonService.hiError(name);
    }
}
