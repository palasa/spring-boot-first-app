package com.bwf.springboot.controller;


import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.resources.Resource;
import com.bwf.springboot.utils.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(Resource.class)
public class HelloController {

    private Resource resource;

    @Autowired
    public HelloController(Resource resource) {
        this.resource = resource;
    }

    @GetMapping("/resource")
    public Resource getResource() {
        return resource;
    }
}
