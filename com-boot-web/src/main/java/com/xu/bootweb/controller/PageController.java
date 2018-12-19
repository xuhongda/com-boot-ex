package com.xu.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuhongda on 2018/12/19
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@Controller
@RequestMapping("page")
public class PageController {

    private static String page = "page/hello";

    @GetMapping("ht")
    public String ht(HttpServletRequest request) {
        request.setAttribute("hello", "hello");
        return page;
    }


    @GetMapping("md")
    public String ht(Model model) {
        model.addAttribute("hello", "hello");
        return page;
    }


    @GetMapping("mv")
    public ModelAndView mv(String str) {
        ModelAndView mv = new ModelAndView(page);
        mv.addObject("hello", str);
        return mv;
    }


    @GetMapping("fw")
    public String fw() {
        return "redirect:http://www.baidu.com";
    }
}
