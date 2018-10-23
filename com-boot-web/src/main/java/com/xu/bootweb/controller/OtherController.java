package com.xu.bootweb.controller;

import entity.Girl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/10/23
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
public class OtherController {

    @GetMapping("/other")
    public Girl other() {
        Girl girl = new Girl();
        girl.setAge("18");
        return girl;
    }
}
