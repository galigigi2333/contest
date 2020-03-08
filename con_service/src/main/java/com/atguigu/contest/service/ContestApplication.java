package com.atguigu.contest.service;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.atguigu.contest.service.mapper")
@EnableSwagger2
public class ContestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContestApplication.class);
    }
}
