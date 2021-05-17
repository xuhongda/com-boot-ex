package com.xu.bootweb.event;

import com.xu.bootweb.listener.MyEvent;
import com.xu.bootweb.listener.MyEventPublisher;
import com.xu.bootweb.listener.MyEventPublisherByContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuhongda on 2018/12/14
 * com.xu.bootweb.event
 * com-boot-ex
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyEventTest {
    @Autowired
    private MyEventPublisher publisher;

    @Autowired
    private MyEventPublisherByContext publisher2;

    @Test
    public void test() {
        MyEvent event = new MyEvent(this);
        publisher.publish(event);

        publisher2.pub(event);
    }
}
