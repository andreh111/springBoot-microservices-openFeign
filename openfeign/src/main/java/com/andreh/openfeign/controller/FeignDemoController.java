package com.andreh.openfeign.controller;


import com.andreh.openfeign.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class FeignDemoController {

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @GetMapping("/user-name")
    public String getUsername(){
        return feignServiceUtil.getName();
    }

    @GetMapping("/user-address")
    public String getUserAdd(){
        return feignServiceUtil.getAddress();
    }

    @GetMapping("/user-status")
    public String getUserStatus(){
        return feignServiceUtil.getStatus();
    }
}
