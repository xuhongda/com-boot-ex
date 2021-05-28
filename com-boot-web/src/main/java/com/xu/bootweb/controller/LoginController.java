package com.xu.bootweb.controller;

import com.xu.bootweb.annotation.LoginUser;
import entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author xuhongda on 2019/6/18
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@Slf4j
@RestController
@RequestMapping("user")
public class LoginController {

    @PostMapping("/re")
    public void register(Account account, HttpServletResponse response) throws IOException, ClassNotFoundException {

        log.info(" register acc = {}",account.toString());
        response.getWriter().println("OK");
    }


    @GetMapping("/login")
    @LoginUser
    public Account login(Account account){

        log.info("  account = {}",account);
        return account;
    }
}
