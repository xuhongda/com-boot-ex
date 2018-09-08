package com.xu.bootweb.controller;

import com.xu.bootweb.MyRepository;
import com.xu.bootweb.mybatis.UserDao;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuhongda on 2018/8/1
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    private final MyRepository myRepository;

    private final UserDao userDao;

    @Autowired
    public HelloController(MyRepository myRepository, UserDao userDao) {
        this.myRepository = myRepository;
        this.userDao = userDao;
    }

    @GetMapping("test1")
    public UserEntity test1(){
        return myRepository.get();
    }

    @GetMapping("test2")
    public List<UserEntity> test2() {
        return userDao.getAll();
    }

    @GetMapping("test3")
    public void test3() {
        throw new RuntimeException();
    }

}
