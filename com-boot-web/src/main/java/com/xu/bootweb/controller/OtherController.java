package com.xu.bootweb.controller;

import entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *     springBoot 引入spring.xml 文件
 * </p>
 * @author xuhongda on 2018/10/23
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
public class OtherController {

    @Autowired
    private Girl girl;

    @GetMapping("/other")
    public Girl other() {
        return girl;
    }
}
