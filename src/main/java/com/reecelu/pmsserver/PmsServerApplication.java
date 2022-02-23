package com.reecelu.pmsserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.reecelu.pmsservice.dao")

public class PmsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmsServerApplication.class, args);
    }

}
