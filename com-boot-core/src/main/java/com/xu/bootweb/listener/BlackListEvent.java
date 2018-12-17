package com.xu.bootweb.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author xuhongda on 2018/12/17
 * com.xu.bootweb.listener
 * com-boot-ex
 */
@Slf4j
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    /**
     * 当 监听 El 表达式规则是，修饰符需要public
     */
    public final String content;

    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    // accessor and other methods...

    public void todoOne() {
        log.info("BlackListEvent to do something");
    }
}
