package com.hsgumussoy.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gateway")
public class TestController {
    @GetMapping
    public String get(){
        return "Bu gateway dostum";
    }
}
