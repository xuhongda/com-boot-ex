package com.xu.bootweb.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 事件监听 通过 spring 注解方式
 * </p>
 *
 * @author xuhongda on 2018/12/17
 * com.xu.bootweb.listener
 * com-boot-ex
 */
@Slf4j
@Component
public class ListenerByAnotation {


    @EventListener
    public void processBlackListEvent(BlackListEvent event) {
        log.info("监听到 Event by spring Annotation  ：{}", event.getClass().getName());
        // notify appropriate parties via notificationAddress...
        event.todoOne();
    }


    @EventListener
    public MyEvent xx(BlackListEvent event) {
        log.info("监听到 Event by spring Annotation  ：{}", event.getClass().getName());
        // notify appropriate parties via notificationAddress...
        event.todoOne();
        log.info("返回一个事件");
        return new MyEvent(this);
    }

    /**
     * 监听多个事件
     */
    @EventListener({MyEvent.class, BlackListEvent.class})
    public void handleContextStart() {
        log.info(" several events... ");
    }

    /**
     * El 表达式条件
     */
    @Order(2)
    @EventListener(condition = "#blEvent.content == 'my-event'")
    public void process(BlackListEvent blEvent) {
        // notify appropriate parties via notificationAddress...
        log.info("符合 El 表达式 ");
    }

}
