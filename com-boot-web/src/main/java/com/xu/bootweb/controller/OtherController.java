package com.xu.bootweb.controller;

import entity.Girl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OtherController {

    @Autowired
    private Girl girl;

    @GetMapping("/other")
    public Girl other() {
        log.info("读取spring-xml配置文件");
        return girl;
    }

    /**
     * 验证 spring  单例；在多个controller类不同请求中为Girl对象执行操作
     *
     * @return
     */
    @GetMapping("sg")
    public Girl sg() {
        girl.setAge(girl.getAge() + 1);
        return girl;
    }
}
