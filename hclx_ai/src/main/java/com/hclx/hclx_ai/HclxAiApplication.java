package com.hclx.hclx_ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hclx.hclx_ai.mapper")
public class HclxAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HclxAiApplication.class, args);
    }

}
