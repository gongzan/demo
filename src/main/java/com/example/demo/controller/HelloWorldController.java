package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${avatarPath}")
    private  String ava;

    private Logger log = LoggerFactory.getLogger(HelloWorldController.class);



    @GetMapping("index")
    public String index(){

        log.info("HelloWorldController-log测试info日志");
        log.debug("HelloWorldController-log测试debug日志");
        log.error("HelloWorldController-log测试error日志");

        return ava;
    }
}
