package com.xu.bootweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.bootweb.listener.MyEvent;
import com.xu.bootweb.listener.MyEventPublisher;
import entity.Girl;
import entity.PeoPle;
import entity.Result;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     springBoot 引入spring.xml 文件
 * </p>
 * @author xuhongda on 2018/10/23
 * com.xu.bootweb.controller
 * com-boot-ex
 */
@RestController
@Slf4j
@RequestMapping("other")
public class OtherController {

    private ObjectMapper mapper = new ObjectMapper();

    private StringWriter writer = new StringWriter();

    private final Girl girl;
    private final PeoPle peoPle;

    private final MyEventPublisher myEventPublisher;

    @Autowired
    public OtherController(Girl girl, MyEventPublisher myEventPublisher,PeoPle peoPle) {
        this.girl = girl;
        this.peoPle = peoPle;
        this.myEventPublisher = myEventPublisher;
    }

    @GetMapping("gl")
    public Girl gl(Girl girl) {
        log.info("读取spring-xml配置文件");
        return girl;
    }

    /**
     * 验证 spring  单例；在多个controller类不同请求中为Girl对象执行操作
     *
     * @return Girl
     */
    @GetMapping("sg")
    public Girl sg() {
        log.info("pre age === {}",girl.getAge() );
        girl.setAge(girl.getAge() + 1);
        log.info("after age === {}",girl.getAge() );
        return girl;
    }

    /**
     * 发布事件
     *
     * @return String
     */
    @GetMapping("eve")
    public String eve() {
        MyEvent event = new MyEvent(this);
        myEventPublisher.publish(event);
        return "已发布事件";
    }

    @GetMapping("json")
    public Result<User> testJson() throws IOException {
        User user = new User();
        Girl g = new Girl();
        g.setAge(18);
        g.setPassword("123");
        Girl g2 = new Girl();
        g2.setAge(18);
        g2.setPassword("123");
        List<Girl> girls = new ArrayList<>();
        girls.add(g);
        girls.add(g2);
        user.setGirls(girls);
        Result<User> result = new Result<>();
        result.setData(user);
        return result;
    }

    @GetMapping("p")
    public PeoPle getPeople(){
        return peoPle;
    }




}
