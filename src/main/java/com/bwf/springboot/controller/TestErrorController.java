package com.bwf.springboot.controller;

import com.bwf.springboot.entity.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("err")
public class TestErrorController {


    @GetMapping("errPage")
    public String error() {
        int a = 1 / 0;
        return "thymeleaf/err";
    }

    @GetMapping("ajaxPage")
    public String ajaxPage() {
        return "thymeleaf/ajaxPage";
    }

    @GetMapping("ajaxErr")
    public JsonResult ajaxErr() {
        int a = 1 / 0;
        return null;
    }

}
