package com.xu.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuhongda on 2021/4/27
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@Controller
public class ViewResolversTestController {

    @RequestMapping("vv")
    public String vv(){
        return "view";
    }
}
