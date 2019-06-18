package com.xu.bootweb.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xuhongda on 2018/12/17
 * com.xu.bootweb.listener
 * com-boot-ex
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ListenerByAnoTest {

    @Autowired
    private MyEventPublisher publisher;

    @Autowired
    private EmailService emailService;

    @Test
    public void processBlackListEvent() {
        BlackListEvent blackListEvent = new BlackListEvent(this, "", "");
        publisher.publish(blackListEvent);
    }


    @Test
    public void process() {
        List<String> bl = new ArrayList<>();
        bl.add("a");
        emailService.setBlackList(bl);
        emailService.sendEmail("a", "my-event");
    }
}