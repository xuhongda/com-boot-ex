package com.xu.bootweb.controller;

import entity.Girl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2021/4/27
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
public class ArgumentResolversTestController {

    @RequestMapping("arg")
    public Girl vv(Girl girl){
        return girl;
    }
}
