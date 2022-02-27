package com.reecelu.pmsserver;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.reecelu.pmsserver.dao")
@SpringBootApplication
public class PmsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmsServerApplication.class, args);
    }

}
