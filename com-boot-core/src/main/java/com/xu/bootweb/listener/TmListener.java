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
@Order(1)
public class TmListener implements ApplicationListener<MyEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info("TmListener 监听到：{}", event.getClass().getName());
    }
}
