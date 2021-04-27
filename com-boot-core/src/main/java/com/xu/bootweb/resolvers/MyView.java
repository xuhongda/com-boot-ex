package com.xu.bootweb.resolvers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.core
 * spring-practice
 */
@Component
@Slf4j
public class MyView implements View {


    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public String getContentType() {
        return "text/html";
    }


    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(model);
        String attribute = (String) request.getAttribute("param");
        System.out.println(attribute);
        response.setContentType("text/html");
        response.getWriter().write("<h3>hello,this is my view creat by xuhongda</h3>");

        //发布我的视图事件
        applicationContext.publishEvent(new MyViewEvent(attribute));
    }
}

@Slf4j
class MyViewEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param attribute the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyViewEvent(String... attribute) {
        super(attribute);
        System.out.println(attribute);
    }


    public void record(){
        log.info("MyViewEvent");
    }
}
