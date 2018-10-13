package com.xu.bootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xuhongda
 */
@SpringBootApplication
@MapperScan("com.xu.bootweb.mapper")
public class WebApplication {

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
