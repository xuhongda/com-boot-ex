package com.xu.bootweb.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/12/14
 * com.xu.bootweb.listener
 * com-boot-ex
 */
@Component
@Slf4j
@Order(2)
public class MyEventListener implements ApplicationListener<MyEvent> {
    /**
     * Handle an application event.
     * 监听到事件发布，决定做什么
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(" start MyEventListener 监听到事件:{}", event.getClass().getName());
        // 处理事件:开始...
        log.info("处理事件开始...");
        event.todoOne();
        event.todoTwo();
        log.info(" end 处理事件结束...");
    }
}
