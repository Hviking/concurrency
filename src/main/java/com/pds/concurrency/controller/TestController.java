package com.pds.concurrency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/concurrency")
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public   String test(){

        return  "uuuu";
    }
}
