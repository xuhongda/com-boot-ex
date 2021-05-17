package com.xu.bootweb.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2020/11/16
 * com.xu.bootweb.listener
 * com-boot-ex
 *
 * 用 ApplicationContext publishEvent 方法发布事件
 */
@Component
public class MyEventPublisherByContext {

    @Autowired
    private ApplicationContext applicationContext;

    public void pub(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }

}
