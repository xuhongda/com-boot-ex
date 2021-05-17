package com.xu.bootweb.controller;

import com.xu.bootweb.exception.ZeRoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author by xuhongda 2021/5/16
 * com.xu.bootweb.controller
 * com-boot-ex
 **/
@Controller
public class ExceptionController {

    /**
     * create a exception
     */
    @RequestMapping("/ee")
    public void ee(){
        throw new ZeRoException("777");
    }
}
