package com.xu.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuhongda on 2019/3/27
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@Controller
public class SocketController {
    @GetMapping("socket")
    public String soc(){
        return "page/socket";
    }
}
