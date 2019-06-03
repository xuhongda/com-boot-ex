package com.xu.bootweb.resourceTest;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

/**
 * @author xuhongda on 2018/10/13
 * com.xu.bootweb.resourceTest
 * com-boot-ex
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceTest {


    private static final double C = Math.PI / 180;

    /**
     * spring 路径
     * guava 读取文件
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //spring 文件路径
        ConfigurableApplicationContext ctx = new GenericApplicationContext();
        Resource resource = ctx.getResource("txt/test.txt");
        // Resource resource = ctx.getResource("classpath:txt/resourceTest.txt");
        File file1 = resource.getFile();
        List<String> strings = Files.readLines(file1, Charsets.UTF_8);
        strings.forEach(System.out::println);
    }

    /**
     * {@link PropertiesConfiguration} 读取Properties配置文件
     * @throws  ConfigurationException exception
     */
    @Test
    public void test2() throws ConfigurationException {
        String fileName = "test.properties";
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(fileName);
        String name = (String)propertiesConfiguration.getProperty("name");
        log.info("name = {}",name);
    }




}
