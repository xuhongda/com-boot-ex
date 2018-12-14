package com.xu.bootweb.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @author xuhongda on 2018/12/14
 * com.xu.bootweb.listener
 * com-boot-ex
 */
@Slf4j
public class MyEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = -3403756919117361198L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }

    public void todoOne() {
        log.info("do something");
    }

    void todoTwo() {
        log.info("do something");
    }

}
