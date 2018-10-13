package com.xu.bootweb.dao;

import com.xu.bootweb.mapper.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;

/**
 * @author xuhongda on 2018/9/29
 * com.xu.bootweb.dao
 * com-boot-ex
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        // userDao.getAll().parallelStream().filter(a->a.getId()>100).collect(Collectors.toList()).forEach(System.out::println);
    }

}
