package com.bwf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {


    public String error() {
        int a = 1 / 0;
        return "error";
    }
}
