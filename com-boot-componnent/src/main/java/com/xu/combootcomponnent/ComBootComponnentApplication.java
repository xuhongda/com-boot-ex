package com.xu.combootcomponnent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuhongda
 */
@SpringBootApplication
@MapperScan("com.xu.combootcomponnent.mapper")
public class ComBootComponnentApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ComBootComponnentApplication.class, args);
    }
}
