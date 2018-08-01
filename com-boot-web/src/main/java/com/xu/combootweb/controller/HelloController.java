package com.xu.combootweb.controller;

import com.xu.combootcomponnent.entity.UserEntity;
import com.xu.combootcomponnent.service.impl.InterfaceTestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2018/8/1
 * com.xu.combootweb.controller
 * com-boot-ex
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    InterfaceTestImpl interfaceTest;

    @GetMapping("test1")
    @ResponseBody
    public String test1(){
        return "test1";
    }

    @GetMapping("test2")
    public String test2(){
        return "test/test1";
    }

    @GetMapping("test3")
    public UserEntity test3(@RequestParam(defaultValue = "1L",value = "l") long l){
        return interfaceTest.getoneUser(l);
    }
}
