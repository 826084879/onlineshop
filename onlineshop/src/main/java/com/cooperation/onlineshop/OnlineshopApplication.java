package com.cooperation.onlineshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cooperation.onlineshop.mapper")
public class OnlineshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineshopApplication.class, args);
    }

}
