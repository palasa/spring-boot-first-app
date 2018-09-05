package com.bwf.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SuppressWarnings("ALL")
@SpringBootApplication
// 扫描 mybatis mapper
@MapperScan(basePackages = {"com.bwf.springboot.mapper.xml", "com.bwf.springboot.mapper"})
// 扫描 自定义工具类
@ComponentScan(basePackages = {"com.bwf.springboot", "org.n3r.idworker"})
// 允许 自动定时启动任务
@EnableScheduling
// 允许 异步任务
@EnableAsync
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
