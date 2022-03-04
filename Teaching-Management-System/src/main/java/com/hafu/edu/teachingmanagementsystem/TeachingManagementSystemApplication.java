package com.hafu.edu.teachingmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@Component("com.hafu.edu.teachingmanagementsystem.controller")
@MapperScan("com.hafu.edu.teachingmanagementsystem.dao")
@SpringBootApplication
public class TeachingManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeachingManagementSystemApplication.class, args);
    }
}
