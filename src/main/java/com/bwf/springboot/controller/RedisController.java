package com.bwf.springboot.controller;

import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.utils.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("test")
    public JsonResult test(){
        redisTemplate.opsForValue().set("cache" , "hello , nihao");

        return JsonResultUtil.success( redisTemplate.opsForValue().get("cache") );
    }
}
