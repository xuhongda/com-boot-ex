package com.xu.bootweb.controller;

import entity.Girl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xuhongda on 2018/9/12
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
public class RestfulController {
    /**
     * 路径正则表达式匹配
     * regx: \d 匹配数字
     * @return String
     */
    @GetMapping("/rest/{id:\\d+}")
    public String regex(@PathVariable("id") String num) {
        return "regex-->" + num;
    }

    /**
     * <p>
     * 加上 @Valid 后，将按照 {@link Girl} 定义的规则校验
     * </P>
     *
     * @param girl girl
     * @return Girl
     */
    @GetMapping("getGirl")
    public Girl getGirl(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().parallelStream().forEach(a -> System.out.println(a.getDefaultMessage()));
        }
        return girl;
    }
}
