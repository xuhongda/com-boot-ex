package com.xu.bootweb.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xu.bootweb.MyRepository;
import com.xu.bootweb.mapper.UserDao;
import com.xu.bootweb.properties.MyProperties;
import entity.Girl;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private final MyProperties myProperties;

    private final UserDao userDao;
    @Value("${com.xu.Girl.age}")
    private String param;

    @GetMapping("hello")
    public String hello(String s) {
        return param;
    }

    @Autowired
    public HelloController(MyRepository myRepository, MyProperties myProperties, UserDao userDao) {
        this.myRepository = myRepository;
        this.myProperties = myProperties;
        this.userDao = userDao;
    }

    @GetMapping("test1")
    public UserEntity test1(){
        return myRepository.get();
    }


    @GetMapping("test3")
    public void test3() {
        throw new RuntimeException();
    }

    /**
     * 简化视图
     *
     * @return
     */
    @JsonView(Girl.GirlSimpleView.class)
    @GetMapping("test4")
    public Girl test4() {
        return myRepository.getGirl();
    }


    @GetMapping("test5")
    public Girl test5(Girl girl) {
        return myRepository.getGirl();
    }


    @GetMapping("test6")
    public Object test6() {
        Girl girl = myProperties.getGirl();
        return girl;
    }




}
