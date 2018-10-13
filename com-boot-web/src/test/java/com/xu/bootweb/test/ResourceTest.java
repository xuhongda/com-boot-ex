package com.xu.bootweb.test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;

/**
 * @author xuhongda on 2018/10/13
 * com.xu.bootweb.test
 * com-boot-ex
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceTest {

    /**
     * guava 读取文件
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //spring 文件路径
        ConfigurableApplicationContext ctx = new GenericApplicationContext();
        Resource resource = ctx.getResource("classpath:txt/test.txt");
        File file1 = resource.getFile();
        List<String> strings = Files.readLines(file1, Charsets.UTF_8);
        strings.forEach(System.out::println);
    }

}
