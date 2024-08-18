package com.ychs.lawfirmsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ychs.lawfirmsys.mapper")
@SpringBootApplication
public class LawFirmSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LawFirmSysApplication.class, args);
    }

}
