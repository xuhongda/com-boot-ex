package com.xu.bootweb.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * @author xuhongda on 2018/11/29
 * com.xu.bootweb.listener
 * com-boot-ex
 */
@Slf4j
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("start");
        System.out.println("start...");
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("end...");
    }


}