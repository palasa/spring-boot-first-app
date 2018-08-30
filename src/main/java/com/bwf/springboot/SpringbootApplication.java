package com.bwf.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SuppressWarnings("ALL")
@SpringBootApplication
@MapperScan(basePackages = "com.bwf.springboot.mapper.xml")
@ComponentScan(basePackages = {"com.bwf.springboot", "org.n3r.idworkder"})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
