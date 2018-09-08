package com.xu.bootweb.controller;

import com.xu.bootweb.MyRepository;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2018/8/1
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    private final MyRepository myRepository;

    @Autowired
    public HelloController(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @GetMapping("test1")
    @ResponseBody
    public UserEntity test1(){
        return myRepository.get();
    }

    @GetMapping("test2")
    public String test2(){
        return "test/test1";
    }

}
