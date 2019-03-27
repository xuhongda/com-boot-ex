package com.xu.bootweb.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xu.bootweb.MyRepository;
import com.xu.bootweb.exception.ZeRoException;
import com.xu.bootweb.mapper.CityMapper;
import com.xu.bootweb.mapper.UserDao;
import com.xu.bootweb.properties.MyProperties;
import entity.Girl;
import entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xuhongda on 2018/8/1
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {

    private final CityMapper cityMapper;

    private final MyRepository myRepository;

    private final MyProperties myProperties;

    private final UserDao userDao;

    private final Girl girl;

    @Value("${com.xu.Girl.age}")
    private String param;

    @GetMapping("hello")
    public String hello(String s) {
        return param;
    }

    @Autowired
    public HelloController(MyRepository myRepository, MyProperties myProperties, UserDao userDao, CityMapper cityMapper, Girl girl) {
        this.myRepository = myRepository;
        this.myProperties = myProperties;
        this.userDao = userDao;
        this.cityMapper = cityMapper;
        this.girl = girl;
    }

    @GetMapping("test1")
    public UserEntity test1() {
        girl.setAge(girl.getAge() + 2);
        log.info("{}", girl);
        return myRepository.get();
    }


    @GetMapping("test2")
    public void test2(Girl girl) {
        throw new NullPointerException(girl.toString());
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
    public Girl test5(@Valid Girl girl) {
        log.info("girl={}", girl);
        return myRepository.getGirl();
    }

    /**
     * 配置文件
     *
     * @return
     */
    @GetMapping("test6")
    public Object test6() {
        return myProperties.getGirl();
    }

    /**
     * 自定义异常处理
     *
     * @return
     */
    @GetMapping("test7")
    public Object test7() {

        // int i = 100 / 0;
        throw new ZeRoException("ec");
        // return i;
    }

    /**
     * 事务
     */
    @GetMapping("test8")
    @Transactional(rollbackFor = Exception.class)
    public void test8() {
        method();
        throw new RuntimeException();
    }

    private void method() {
        cityMapper.deleteByPrimaryKey(103);
        throw new RuntimeException("com.xu.bootweb.exception");
    }



}
