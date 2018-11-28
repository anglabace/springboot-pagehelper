package com.xiao.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by jinwei.sun on 2017/2/24.
 *
 * @author sunjinwei
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiao"})
@MapperScan("com.xiao.dao.mapper")
@ImportResource({"classpath:spring-config.xml"})
public class IndexMain {

    public static void main(String[] args) {
        SpringApplication.run(IndexMain.class, args);
    }
}
