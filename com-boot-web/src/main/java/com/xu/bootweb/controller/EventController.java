package com.xu.bootweb.controller;

import com.xu.bootweb.listener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongda on 2018/12/14
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
@Slf4j
public class EventController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    /**
     * Set the ApplicationEventPublisher that this object runs in.
     * <p>Invoked after population of normal bean properties but before an init
     * callback like InitializingBean's afterPropertiesSet or a custom init-method.
     * Invoked before ApplicationContextAware's setApplicationContext.
     *
     * @param applicationEventPublisher event publisher to be used by this object
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }


    /**
     * <p>
     * 在一个请求中发布某个自定义事件,在这种情况下自定义Filter不会生效
     * </p>
     *
     * @return String
     */
    @GetMapping("eve")
    public String eve() {
        MyEvent myEvent = new MyEvent(this);
        log.info("请求eve 发布事件：{}", myEvent.getClass().getName());
        eventPublisher.publishEvent(myEvent);
        return "已发布事件";
    }


}
