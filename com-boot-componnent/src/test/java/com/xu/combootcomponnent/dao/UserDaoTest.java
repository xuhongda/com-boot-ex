package com.xu.combootcomponnent.dao;

import com.xu.combootcomponnent.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuhongda on 2018/8/2
 * com.xu.combootcomponnent.dao
 * com-boot-ex
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(UserDao.class)
public class UserDaoTest {
    @Autowired
    private  UserDao userDao;
    @Test
    public void test1(){
        UserEntity one = userDao.getById(28L);
        System.out.println(one);
    }
}
