package com.xu.bootweb.processor;

import entity.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author xuhongda on 2021/5/17
 * com.xu.bootweb.processor
 * com-boot-ex
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(" MyBeanPostProcessor ");
        if ("car".equals(beanName)){
            Car car = (Car)bean;
            car.setColor("green");
        }
        return bean;
    }
}
