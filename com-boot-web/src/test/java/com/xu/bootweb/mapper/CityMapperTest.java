package com.xu.bootweb.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author xuhongda on 2018/9/30
 * com.xu.bootweb.mapper
 * com-boot-ex
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTest {
    @Autowired
    private CityMapper cityMapper;

    @Test
    public void selectByPrimaryKey() {
        System.out.println(cityMapper.selectByPrimaryKey(1));
    }
}