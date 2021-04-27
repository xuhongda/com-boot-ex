package com.xu.bootweb.resolvers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author xuhongda on 2020/11/9
 * com.xu.core
 * spring-practice
 */
@Slf4j
@Component
public class MyViewResolver implements ViewResolver, Ordered {


    private Integer order;

    @Autowired
    private MyView myView;


    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        System.out.println(viewName);
        if ("view".equals(viewName)){
            return myView;
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public void setOrder(Integer order){
        this.order = order;

    }
}
