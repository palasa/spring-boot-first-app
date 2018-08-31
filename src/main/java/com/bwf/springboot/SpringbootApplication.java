package com.bwf.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SuppressWarnings("ALL")
@SpringBootApplication
@MapperScan(basePackages = {"com.bwf.springboot.mapper.xml", "com.bwf.springboot.mapper"})
@ComponentScan(basePackages = {"com.bwf.springboot", "org.n3r.idworker"})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
