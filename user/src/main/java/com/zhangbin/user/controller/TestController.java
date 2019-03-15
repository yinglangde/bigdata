package com.zhangbin.user.controller;

import com.zhangbin.user.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @RequestMapping("/userTest")
    public String test(){
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

        return testService.userTest();
    }


}
