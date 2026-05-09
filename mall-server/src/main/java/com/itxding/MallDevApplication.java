package com.itxding;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 扫描com.mall下所有的bean，包括common模块的配置类
@SpringBootApplication(scanBasePackages= "com.itxding")
// 扫描mapper接口
@MapperScan("com.itxding.mapper")
public class MallDevApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallDevApplication.class, args);
    }
}