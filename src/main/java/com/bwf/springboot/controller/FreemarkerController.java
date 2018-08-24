package com.bwf.springboot.controller;

import com.bwf.springboot.resources.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    private final Resource resource;

    @Autowired
    public FreemarkerController(Resource resource) {
        this.resource = resource;
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center() {
        return "freemarker/center/center";
    }
}
