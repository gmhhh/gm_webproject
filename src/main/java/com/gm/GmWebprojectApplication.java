package com.gm;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.gm.mapper")
@ComponentScan(basePackages = {"com.gm.controller","com.gm.service","com.gm.config"})
@SpringBootApplication
public class GmWebprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmWebprojectApplication.class, args);
    }

}
